package com.parkingfinder.web.service.job;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingfinder.web.model.Parking;
import com.parkingfinder.web.service.ParkingService;

@Service("JobManager")
public class JobManager extends Thread {

    public static final Long JOB_DELAY = 60000L;

    private static final Logger logger = Logger.getLogger("JobManager");

    @Autowired
    private ParkingService parkingService;

    public void run() {
        while (true) {
            try {
                createJobs();
                Thread.sleep(JOB_DELAY);
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    public void createJobs() {
        List<Parking> parking = parkingService.getAllParking();
        logger.info(String.format("Create jobs for each of %d parking", parking.size()));
        parking.parallelStream().forEach((item) -> new Job(item, parkingService).start());
    }

}
