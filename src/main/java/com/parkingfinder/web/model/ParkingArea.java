package com.parkingfinder.web.model;

import java.util.ArrayList;
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
public class ParkingArea {

    @Id
    @GeneratedValue
    @Column(name = "PARKING_AREA_ID")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private Point center;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Point> area = new ArrayList<>();

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Rectangle> spaces = new ArrayList<>();

    private Integer size;

    private Integer freeSpacesNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public List<Point> getArea() {
        return area;
    }

    public void setArea(List<Point> area) {
        this.area = area;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getFreeSpacesNum() {
        return freeSpacesNum;
    }

    public void setFreeSpacesNum(Integer freeSpacesNum) {
        this.freeSpacesNum = freeSpacesNum;
    }

    public List<Rectangle> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<Rectangle> spaces) {
        this.spaces = spaces;
    }
}
