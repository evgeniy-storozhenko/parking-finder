package com.parkingfinder.analyzer;

import com.parkingfinder.web.model.Parking;

import java.util.logging.Logger;

public class Analyzer {

    private static Analyzer instance = null;
    private static final Logger logger = Logger.getLogger("Analyzer");

    private Analyzer() {
    }

    public synchronized static Analyzer getInstance() {
        if (instance == null) {
            instance = new Analyzer();
        }
        return instance;
    }

    public void analyze(Parking parking) {
        logger.info("Analyze parking " + parking.getId());
        // TODO analyze
    }

}
