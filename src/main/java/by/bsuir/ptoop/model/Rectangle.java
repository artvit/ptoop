package by.bsuir.ptoop.model;

public class Rectangle extends ShapeFigure {
    private double x;
    private double y;
    private double height;
    private double width;

    public Rectangle(int color, int fillColor, double x, double y, double height, double width) {
        super(color, fillColor);
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
