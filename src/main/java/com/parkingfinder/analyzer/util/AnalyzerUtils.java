package com.parkingfinder.analyzer.util;

import com.parkingfinder.web.model.Point;

public class AnalyzerUtils {

    public static com.parkingfinder.web.model.Rectangle convert(java.awt.Rectangle rect) {
        com.parkingfinder.web.model.Rectangle result = new com.parkingfinder.web.model.Rectangle();
        result.setMaxLeft(new Point(rect.getX(), rect.getY()));
        result.setMaxRight(new Point(rect.getX() + rect.getWidth(), rect.getY()));
        result.setMinRight(new Point(rect.getX() + rect.getWidth(), rect.getY() + rect.getHeight()));
        result.setMinLeft(new Point(rect.getX(), rect.getY() + rect.getHeight()));
        return result;
    }

}
