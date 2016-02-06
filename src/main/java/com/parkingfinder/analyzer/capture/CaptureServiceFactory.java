package com.parkingfinder.analyzer.capture;

import com.parkingfinder.analyzer.capture.impl.CaptureM3u8;
import com.parkingfinder.web.model.Parking;

public class CaptureServiceFactory {

    public static CaptureService createCaptureService(Parking parking) {
        if (parking.getSource().getType().equals("m3u8")) {
            return new CaptureM3u8(parking);
        }
        return null;
    }

}
