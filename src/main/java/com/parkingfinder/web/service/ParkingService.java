package com.parkingfinder.web.service;

import java.util.List;

import com.parkingfinder.web.model.Parking;

public interface ParkingService {

    Parking getParking(Long id);

    List<Parking> getAllParking();

    Parking save(Parking parking);
}
