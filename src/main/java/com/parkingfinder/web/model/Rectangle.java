package com.parkingfinder.web.model;

import org.springframework.data.geo.Point;

public class Rectangle {

    private Point minLeft;
    private Point minRight;
    private Point maxLeft;
    private Point maxRight;

    public Rectangle(Point minLeft, Point minRight, Point maxLeft, Point maxRight) {
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
}
