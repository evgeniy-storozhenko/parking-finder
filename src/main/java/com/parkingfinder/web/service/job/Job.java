package com.parkingfinder.web.service.job;

import java.io.File;
import java.util.Date;

import com.parkingfinder.analyzer.capture.CaptureService;
import com.parkingfinder.analyzer.capture.CaptureServiceFactory;
import com.parkingfinder.web.model.Parking;
import com.parkingfinder.web.model.Status;

public class Job extends Thread {

    private Date started;

    private Date finished;

    private Status status;

    private Parking parking;

    private CaptureService service;

    public Job(Parking parking) {
        this.started = new Date();
        this.status = Status.WAITING;
        this.parking = parking;
    }

    public void run() {
        this.status = Status.IN_PROGRESS;
        service = CaptureServiceFactory.createCaptureService(parking);

        try {
            File image = service.captureLastImage();
            if (image != null) {
                // todo
            }
            this.status = Status.SUCCESS;
        } catch (Exception e) {
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

    public void setParking(Parking parking) {
        this.parking = parking;
    }
}
