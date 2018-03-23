package by.bsuir.oop.gui.drawer;

import by.bsuir.oop.model.Figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class FigureDrawer {
    protected GraphicsContext graphicsContext;
    private FigureDrawer nextFigureDrawer;

    public abstract void draw(Figure figure);

    protected Color getFxColor(by.bsuir.oop.model.Color color) {
        return Color.color(color.getRed(), color.getGreen(), color.getBlue());
    }

    public FigureDrawer getNextFigureDrawer() {
        return nextFigureDrawer;
    }

    public void setNextFigureDrawer(FigureDrawer nextFigureDrawer) {
        this.nextFigureDrawer = nextFigureDrawer;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }
}