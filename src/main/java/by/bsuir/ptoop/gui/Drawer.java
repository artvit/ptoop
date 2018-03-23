package by.bsuir.ptoop.gui;

import by.bsuir.ptoop.gui.drawer.*;
import by.bsuir.ptoop.model.Figure;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Drawer {
    private static final List<FigureDrawer> FIGURE_DRAWER_LIST = List.of(
            new CircleDrawer(),
            new EllipseDrawer(),
            new PointDrawer(),
            new LineDrawer(),
            new RectangleDrawer(),
            new TriangleDrawer()
    );

    private FigureDrawer firstFigureDrawer;
    private GraphicsContext graphicsContext;

    public Drawer(Canvas canvas) {
        graphicsContext = canvas.getGraphicsContext2D();

        firstFigureDrawer = FIGURE_DRAWER_LIST.stream().reduce(null , (accumulator, current)-> {
            current.setGraphicsContext(graphicsContext);
            current.setNextFigureDrawer(accumulator);
            return current;
        });
    }

    public void drawFigure(Figure figure) {
        firstFigureDrawer.draw(figure);
    }


}
