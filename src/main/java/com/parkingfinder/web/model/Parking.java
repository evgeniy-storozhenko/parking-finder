package com.parkingfinder.web.model;

import org.springframework.data.geo.Point;

import java.util.Date;
import java.util.List;

public class Parking {

    private Long id;

    private String name;

    private String source;

    private Date lastUpdate;

    private String lastImage;

    private Point coordinate;

    private List<ParkingPlace> places;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ParkingPlace> getPlaces() {
        return places;
    }

    public void setPlaces(List<ParkingPlace> places) {
        this.places = places;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLastImage() {
        return lastImage;
    }

    public void setLastImage(String lastImage) {
        this.lastImage = lastImage;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }
}
