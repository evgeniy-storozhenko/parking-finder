package com.parkingfinder.web.service.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.parkingfinder.web.model.Parking;
import com.parkingfinder.web.service.ParkingService;

@Service("JobManager")
public class JobManager extends Thread {

    public static final Long JOB_DELAY = 60000L;

    @Qualifier("parkingService")
    @Autowired
    private ParkingService parkingService;

    public void run() {
        while (true) {
            try {
                createJob();
                Thread.sleep(JOB_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void createJob() {
        List<Parking> parking = parkingService.getAllParking();
        parking.parallelStream().forEach((item) -> new Job(item).start());
    }

}
