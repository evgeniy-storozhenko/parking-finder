package com.parkingfinder.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Parking {

    @Id
    @GeneratedValue
    @Column(name = "PARKING_ID")
    private Long id;

    private String name;

    @OneToOne (cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private Source source;

    @OneToOne (cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private Point size;

    private Date lastUpdate;

    private String lastImage;

    @OneToOne (cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private Point coordinate;

    @OneToOne (cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private City city;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Rectangle> cars = new ArrayList<>();

    @OneToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<ParkingArea> areas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<ParkingArea> getAreas() {
        return areas;
    }

    public void setAreas(List<ParkingArea> areas) {
        this.areas = areas;
    }

    public Point getSize() {
        return size;
    }

    public void setSize(Point size) {
        this.size = size;
    }

    public List<Rectangle> getCars() {
        return cars;
    }

    public void setCars(List<Rectangle> cars) {
        this.cars = cars;
    }
}
