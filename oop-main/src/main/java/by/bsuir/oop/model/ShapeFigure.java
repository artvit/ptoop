package by.bsuir.oop.model;

public abstract class ShapeFigure extends Figure {
    private Color fillColor;

    public ShapeFigure() {
    }

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

    @Override
    public String toString() {
        return "ShapeFigure{" +
                "fillColor=" + fillColor +
                "} " + super.toString();
    }
}
