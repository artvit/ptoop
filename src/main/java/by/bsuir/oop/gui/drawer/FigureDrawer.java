package by.bsuir.oop.gui.drawer;

import by.bsuir.oop.gui.DrawerException;
import by.bsuir.oop.model.Figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class FigureDrawer {
    protected GraphicsContext graphicsContext;
    private FigureDrawer nextFigureDrawer;

    public void draw(Figure figure) {
        if (supports(figure)) {
            drawFigure(figure);
        } else if (getNextFigureDrawer() != null) {
            getNextFigureDrawer().draw(figure);
        } else {
            throw new DrawerException("Unsupported figure passed to drawer");
        }
    }

    public abstract boolean supports(Figure figure);

    public abstract void drawFigure(Figure figure);

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
