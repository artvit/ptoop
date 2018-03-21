package by.bsuir.ptoop.model;

public class Ellipse extends Circle {
    private double horizontalRadius;

    public Ellipse(int color, int fillColor, double radius, double centerX, double centerY, double horizontalRadius) {
        super(color, fillColor, radius, centerX, centerY);
        this.horizontalRadius = horizontalRadius;
    }

    public double getHorizontalRadius() {
        return horizontalRadius;
    }

    public void setHorizontalRadius(double horizontalRadius) {
        this.horizontalRadius = horizontalRadius;
    }
}
