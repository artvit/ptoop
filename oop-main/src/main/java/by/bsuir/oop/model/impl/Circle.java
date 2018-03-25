package by.bsuir.oop.model.impl;

import by.bsuir.oop.model.Color;
import by.bsuir.oop.model.ShapeFigure;
import by.bsuir.oop.model.exception.FigureCreationException;

public class Circle extends ShapeFigure {
    private double radius;

    private double centerX;
    private double centerY;

    public Circle() {
    }

    public Circle(Color color, Color fillColor, double radius, double centerX, double centerY) throws FigureCreationException {
        super(color, fillColor);
        if (radius <= 0) {
            throw new FigureCreationException("Radius must have positive value");
        }
        if (centerX <= 0 || centerY <= 0) {
            throw new FigureCreationException("Coordinates must have positive value");
        }
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", centerX=" + centerX +
                ", centerY=" + centerY +
                "} " + super.toString();
    }
}
