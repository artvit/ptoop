package by.bsuir.oop.model.impl;

import by.bsuir.oop.model.Color;
import by.bsuir.oop.model.exception.FigureCreationException;

public class Ellipse extends Circle {
    private double horizontalRadius;

    public Ellipse(Color color, Color fillColor, double radius, double centerX, double centerY, double horizontalRadius) throws FigureCreationException {
        super(color, fillColor, radius, centerX, centerY);
        if (horizontalRadius <= 0) {
            throw new FigureCreationException("Radius must have positive value");
        }
        this.horizontalRadius = horizontalRadius;
    }

    public double getHorizontalRadius() {
        return horizontalRadius;
    }

    public void setHorizontalRadius(double horizontalRadius) {
        this.horizontalRadius = horizontalRadius;
    }
}
