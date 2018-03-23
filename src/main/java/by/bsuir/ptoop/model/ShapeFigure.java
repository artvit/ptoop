package by.bsuir.ptoop.model;

public abstract class ShapeFigure extends Figure {
    private Color fillColor;

    public ShapeFigure(Color color, Color fillColor) {
        super(color);
        this.fillColor = fillColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
}
