package by.bsuir.ptoop.model;

public abstract class Figure {
    private int color;

    public Figure(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
