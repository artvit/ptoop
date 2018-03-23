package by.bsuir.oop.model.impl;

import by.bsuir.oop.model.Color;
import by.bsuir.oop.model.ShapeFigure;
import by.bsuir.oop.model.exception.FigureCreationException;

public class Triangle extends ShapeFigure {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(Color color, Color fillColor, double x1, double y1, double x2, double y2, double x3, double y3)
            throws FigureCreationException {
        super(color, fillColor);

        if (x1 <= 0 || y1 <= 0 || x2 <= 0 || y2 <= 0 || x3 <= 0 || y3 <= 0) {
            throw new FigureCreationException("Coordinates must have positive value");
        }

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }
}