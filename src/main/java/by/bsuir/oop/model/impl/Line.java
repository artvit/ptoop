package by.bsuir.oop.model.impl;

import by.bsuir.oop.model.Color;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.exception.FigureCreationException;

public class Line extends Figure {
    private double startX;
    private double startY;

    private double endX;
    private double endY;

    public Line(Color color, double startX, double startY, double endX, double endY) throws FigureCreationException {
        super(color);
        if (startX <= 0 || startY <= 0 || endX <= 0 || endY <= 0) {
            throw new FigureCreationException("Coordinates must have positive value");
        }
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public double getEndX() {
        return endX;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public double getEndY() {
        return endY;
    }

    public void setEndY(double endY) {
        this.endY = endY;
    }
}