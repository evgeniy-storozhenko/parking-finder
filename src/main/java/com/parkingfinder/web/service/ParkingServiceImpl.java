package com.parkingfinder.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parkingfinder.web.model.Parking;
import com.parkingfinder.web.repository.ParkingRepository;

@Service("parkingService")
public class ParkingServiceImpl implements ParkingService {

    @Qualifier("parkingRepository")
    @Autowired
    private ParkingRepository parkingRepository;

    @Override
    @Transactional
    public Parking getParking(Long id) {
        return parkingRepository.getParking(id);
    }

    @Override
    @Transactional
    public List<Parking> getAllParking() {
        return null;
    }

    @Override
    @Transactional
    public Parking save(Parking parking) {
        parkingRepository.save(parking);
        return parking;
    }
}
