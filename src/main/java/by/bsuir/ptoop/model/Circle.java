package by.bsuir.ptoop.model;

public class Circle extends ShapeFigure {
    private double radius;

    private double centerX;
    private double centerY;

    public Circle(int color, int fillColor, double radius, double centerX, double centerY) {
        super(color, fillColor);
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
}
