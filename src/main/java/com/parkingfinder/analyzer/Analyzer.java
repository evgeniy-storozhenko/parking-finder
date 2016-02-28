package com.parkingfinder.analyzer;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.parkingfinder.analyzer.capture.CaptureService;
import com.parkingfinder.web.model.Parking;
import gab.opencv.Line;
import gab.opencv.OpenCV;
import org.springframework.core.io.DefaultResourceLoader;
import processing.core.PApplet;

public class Analyzer {

    private static Analyzer instance = null;
    private static final Logger logger = Logger.getLogger("Analyzer");

    private String absResourcesPath = "";

    private Analyzer() {
        try {
            DefaultResourceLoader loader = new DefaultResourceLoader();
            File recordsDir = loader.getResource(CaptureService.recordsPath + "/../../../").getFile();
            absResourcesPath = recordsDir.getAbsolutePath();
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public synchronized static Analyzer getInstance() {
        if (instance == null) {
            instance = new Analyzer();
        }
        return instance;
    }

    public void analyze(Parking parking) {
        logger.info("Start analyze parking " + parking.getId());

        PApplet pApplet = new PApplet();
        pApplet.sketchPath();

        String imagePath = absResourcesPath + "/" + parking.getLastImage();
        OpenCV opencv = new OpenCV(pApplet, imagePath);
        opencv.loadCascade(OpenCV.CASCADE_FRONTALFACE); // TODO change cascadeFileName
        Rectangle[] rects = opencv.detect();

        logger.info("Loading image: " + parking.getLastImage());
        logger.info("rects: " + rects);
        // TODO analyze
    }

}
