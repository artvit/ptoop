package by.bsuir.oop.gui.drawer;

import by.bsuir.oop.gui.DrawerException;
import by.bsuir.oop.model.Figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Basic class which implements Chain of Responsibility pattern
 * for drawing figures.
 */
public abstract class FigureDrawer {
    protected GraphicsContext graphicsContext;
    private FigureDrawer nextFigureDrawer;

    /**
     * Draws figure if it is supported or passes it to next drawer
     *
     * @param figure Figure
     */
    public void draw(Figure figure) {
        if (supports(figure)) {
            drawFigure(figure);
        } else if (getNextFigureDrawer() != null) {
            getNextFigureDrawer().draw(figure);
        } else {
            throw new DrawerException("Unsupported figure passed to drawer");
        }
    }

    /**
     * Checks if figure is supported by drawer
     *
     * @param figure Figure object
     * @return true if supported
     */
    public abstract boolean supports(Figure figure);

    /**
     * Draws figure
     *
     * @param figure Figure to be checked
     */
    public abstract void drawFigure(Figure figure);

    /**
     * Converts our model Color object to Color from JavaFX
     *
     * @param color Color from Figure
     * @return Color from JavaFX
     */
    protected Color getFxColor(by.bsuir.oop.model.Color color) {
        return Color.color(color.getRed(), color.getGreen(), color.getBlue());
    }

    /**
     * returns next figure drawer in chain
     *
     * @return FigureDrawer
     */
    private FigureDrawer getNextFigureDrawer() {
        return nextFigureDrawer;
    }

    /**
     * Sets next FigureDrawer
     *
     * @param nextFigureDrawer next in chain figure drawer
     */
    public void setNextFigureDrawer(FigureDrawer nextFigureDrawer) {
        this.nextFigureDrawer = nextFigureDrawer;
    }

    /**
     * Sets GraphicsContext which is used to drawing figures
     *
     * @param graphicsContext instance of graphicsContext from Canvas
     */
    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }
}
