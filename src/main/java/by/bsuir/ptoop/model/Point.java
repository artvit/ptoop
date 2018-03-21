package by.bsuir.ptoop.model;

public class Point extends Figure {
    private double x;
    private double y;

    public Point(int color, double x, double y) {
        super(color);
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
