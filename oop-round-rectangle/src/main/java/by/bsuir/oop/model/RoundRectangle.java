package by.bsuir.oop.model;

public class RoundRectangle extends ShapeFigure {
    private double x;
    private double y;
    private double height;
    private double width;
    private double cornerRadius;

    public RoundRectangle() {
    }

    public RoundRectangle(Color color, Color fillColor, double x, double y, double height, double width, double cornerRadius) throws FigureCreationException {
        super(color, fillColor);
        if (x <= 0 || y <= 0) {
            throw new FigureCreationException("Coordinates must have positive value");
        }
        if (height <= 0 || width <= 0) {
            throw new FigureCreationException("Dimensions must have positive value");
        }
        if (cornerRadius <= 0) {
            throw new FigureCreationException("Corner radius must have positive value");
        }
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.cornerRadius = cornerRadius;
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

    public double getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(double cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @Override
    public String toString() {
        return "RoundRectangle{" +
                "x=" + x +
                ", y=" + y +
                ", height=" + height +
                ", width=" + width +
                ", cornerRadius=" + cornerRadius +
                "} " + super.toString();
    }
}
