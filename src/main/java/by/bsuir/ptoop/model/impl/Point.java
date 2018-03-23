package by.bsuir.ptoop.model.impl;

import by.bsuir.ptoop.model.Color;
import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.exception.FigureCreationException;

public class Point extends Figure {
    private double x;
    private double y;

    public Point(Color color, double x, double y) throws FigureCreationException {
        super(color);
        if (x <= 0 || y <= 0) {
            throw new FigureCreationException("Coordinates must have positive value");
        }
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
