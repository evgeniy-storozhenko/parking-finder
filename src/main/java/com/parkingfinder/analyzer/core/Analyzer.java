package com.parkingfinder.analyzer.core;

import java.awt.*;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.parkingfinder.analyzer.util.AnalyzerUtils;
import com.parkingfinder.web.model.*;
import org.springframework.core.io.DefaultResourceLoader;

import processing.core.PApplet;

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

        List<com.parkingfinder.web.model.Rectangle> carsPositions = Arrays.stream(cars)
                .map(item -> AnalyzerUtils.convert(item))
                .collect(Collectors.toList());

        parking.setCars(carsPositions);

        // TODO analyze
    }

}
