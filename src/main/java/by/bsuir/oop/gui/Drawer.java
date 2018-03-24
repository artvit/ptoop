package by.bsuir.oop.gui;

import by.bsuir.oop.gui.drawer.FigureDrawer;
import by.bsuir.oop.model.Figure;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public class Drawer {

    private FigureDrawer firstFigureDrawer;
    private GraphicsContext graphicsContext;

    public Drawer(Canvas canvas) {
        graphicsContext = canvas.getGraphicsContext2D();
    }

    /**
     * Draws figure
     *
     * @param figure Figure implementation
     */
    public void drawFigure(Figure figure) {
        firstFigureDrawer.draw(figure);
    }

    /**
     * Adds FigureDrawer to chain of drawers
     *
     * @param figureDrawer FigureDrawer
     */
    public void addDrawer(FigureDrawer figureDrawer) {
        figureDrawer.setGraphicsContext(graphicsContext);
        figureDrawer.setNextFigureDrawer(firstFigureDrawer);
        firstFigureDrawer = figureDrawer;
    }
}
