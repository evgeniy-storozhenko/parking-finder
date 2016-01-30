package com.parkingfinder.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.parkingfinder.web.model.Rectangle;
import javafx.geometry.Rectangle2D;

import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.parkingfinder.web.model.Parking;
import com.parkingfinder.web.model.ParkingPlace;

@Service("ParkingService")
public class ParkingServiceImpl implements ParkingService {

    public Parking getParking(long id) {

        Parking parking = new Parking();
        parking.setId(1L);
        parking.setCoordinate(new Point(74.3, 36.2));
        parking.setLastImage("/1/1454153246.jpg");
        parking.setName("The Crossroads on st.Lenin");
        parking.setSource("http://webcam.211.ru/camera54_6/index.m3u8");
        parking.setLastUpdate(new Date());

        List<ParkingPlace> places = new ArrayList<ParkingPlace>();

        ParkingPlace parkingPlace1 = new ParkingPlace();
        parkingPlace1.setId(10);
        parkingPlace1.setEmpty(true);
        parkingPlace1.setRectangle(new Rectangle(new Point(10, 10), new Point(13, 40),
                new Point(30, 30), new Point(40, 60)));

        ParkingPlace parkingPlace2 = new ParkingPlace();
        parkingPlace2.setId(11);
        parkingPlace2.setEmpty(true);
        parkingPlace2.setRectangle(new Rectangle(new Point(110, 10), new Point(113, 40),
                new Point(130, 30), new Point(140, 60)));

        places.add(parkingPlace1);
        places.add(parkingPlace2);

        parking.setPlaces(places);

        return parking;
    }
}
