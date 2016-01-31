package com.parkingfinder.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parkingfinder.web.model.Parking;

@Repository("parkingRepository")
public interface ParkingRepository extends JpaRepository<Parking, Long> {

    @Query("SELECT p FROM Parking p")
    List<Parking> loadAllGaolReports();

}
