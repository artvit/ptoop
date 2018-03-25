package by.bsuir.oop.model;

import by.bsuir.oop.model.Color;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.FigureCreationException;

public class Point extends Figure {
    private double x;
    private double y;

    public Point() {
    }

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

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                "} " + super.toString();
    }
}
