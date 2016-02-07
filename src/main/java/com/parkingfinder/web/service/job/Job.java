package com.parkingfinder.web.service.job;

import java.io.File;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.parkingfinder.analyzer.Analyzer;
import com.parkingfinder.analyzer.capture.CaptureService;
import com.parkingfinder.analyzer.capture.CaptureServiceFactory;
import com.parkingfinder.web.model.Parking;
import com.parkingfinder.web.model.Status;
import com.parkingfinder.web.service.ParkingService;

public class Job extends Thread {

    private static final Logger logger = Logger.getLogger("Job");

    private Date started;

    private Date finished;

    private Status status;

    private CaptureService service;

    final private Parking parking;

    final private ParkingService parkingService;

    public Job(Parking parking, ParkingService parkingService) {
        this.started = new Date();
        this.status = Status.WAITING;
        this.parking = parking;
        this.parkingService = parkingService;
    }

    public void run() {
        this.status = Status.IN_PROGRESS;
        service = CaptureServiceFactory.createCaptureService(parking);
        if (service == null) {
            logger.info("Don't know, how to get image from this type of source");
            return;
        }
        try {
            File image = service.captureLastImage();
            if (image != null) {
                parking.setLastImage("/resources/images/records/" + image.getName());
                Analyzer.getInstance().analyze(parking);
                parking.setLastUpdate(new Date());
                parkingService.save(parking);
            }
            this.status = Status.SUCCESS;
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            this.status = Status.ERROR;
        }
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getFinished() {
        return finished;
    }

    public void setFinished(Date finished) {
        this.finished = finished;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Parking getParking() {
        return parking;
    }

}
