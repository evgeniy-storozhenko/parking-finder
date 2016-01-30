package com.parkingfinder.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parkingfinder.web.model.Parking;
import com.parkingfinder.web.service.ParkingService;

@Controller
@RequestMapping("/parkingService")
public class ParkingFinder {

    @Autowired
    private ParkingService parkingService;

    @RequestMapping(path = "/parking/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Parking getParking(@PathVariable Long id)
            throws Exception {

        return parkingService.getParking(id);
    }

}