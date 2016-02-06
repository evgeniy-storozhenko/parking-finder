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
public class Rectangle {

    @Id
    @GeneratedValue
    @Column(name = "RECTANGLE_ID")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private Point minLeft;

    @OneToOne (cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private Point minRight;

    @OneToOne (cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private Point maxLeft;

    @OneToOne (cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private Point maxRight;

    public Rectangle(Long id,Point minLeft, Point minRight, Point maxLeft, Point maxRight) {
        this.id = id;
        this.minLeft = minLeft;
        this.minRight = minRight;
        this.maxLeft = maxLeft;
        this.maxRight = maxRight;
    }

    public Rectangle() {
    }

    public Point getMinLeft() {
        return minLeft;
    }

    public void setMinLeft(Point minLeft) {
        this.minLeft = minLeft;
    }

    public Point getMinRight() {
        return minRight;
    }

    public void setMinRight(Point minRight) {
        this.minRight = minRight;
    }

    public Point getMaxLeft() {
        return maxLeft;
    }

    public void setMaxLeft(Point maxLeft) {
        this.maxLeft = maxLeft;
    }

    public Point getMaxRight() {
        return maxRight;
    }

    public void setMaxRight(Point maxRight) {
        this.maxRight = maxRight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
