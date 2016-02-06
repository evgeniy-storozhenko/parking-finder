package com.parkingfinder.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class ParkingPlace {

    @Id
    @GeneratedValue
    @Column(name = "PARKING_PLACE_ID")
    private Long id;

    private boolean empty;

    @OneToOne (cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private Rectangle rectangle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

}
