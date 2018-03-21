package by.bsuir.ptoop.model;

public class ShapeFigure extends Figure {
    private int fillColor;

    public ShapeFigure(int color, int fillColor) {
        super(color);
        this.fillColor = fillColor;
    }

    public int getFillColor() {
        return fillColor;
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
    }
}
