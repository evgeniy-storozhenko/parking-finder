package com.parkingfinder.analyzer;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.core.io.DefaultResourceLoader;

import processing.core.PApplet;

import com.parkingfinder.web.model.Parking;
import gab.opencv.OpenCV;

public class Analyzer {

    private static Analyzer instance = null;
    private static final Logger logger = Logger.getLogger("Analyzer");
    private static final String carCascade = "/resources/cascade-files/my-cars-classifier.xml";

    private String absResourcesPath = "";

    private Analyzer() {
        try {
            DefaultResourceLoader loader = new DefaultResourceLoader();
            absResourcesPath = loader.getResource("../../").getFile().getAbsolutePath();
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

        String imagePath = absResourcesPath + parking.getLastImage();
        OpenCV opencv = new OpenCV(pApplet, imagePath);
        opencv.loadCascade(absResourcesPath + carCascade, true);
        Rectangle[] cars = opencv.detect();

        logger.info("Loading image: " + parking.getLastImage());
        logger.info("Cars: " + cars);

        // TODO analyze
    }

}
