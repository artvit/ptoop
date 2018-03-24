package by.bsuir.oop.gui.drawer;

import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Triangle;
import javafx.scene.paint.Color;

public class TriangleDrawer extends FigureDrawer {

    @Override
    public boolean supports(Figure figure) {
        return figure instanceof Triangle;
    }


    @Override
    public void drawFigure(Figure figure) {
        Triangle line = (Triangle) figure;
        drawTriangle(line);
    }

    private void drawTriangle(Triangle triangle) {
        Color fxStrokeColor = getFxColor(triangle.getColor());
        Color fxFillColor = getFxColor(triangle.getFillColor());

        double[] xCoords = {triangle.getX1(), triangle.getX2(), triangle.getX3()};
        double[] yCoords = {triangle.getY1(), triangle.getY2(), triangle.getY3()};

        graphicsContext.save();

        graphicsContext.setStroke(fxStrokeColor);
        graphicsContext.setFill(fxFillColor);
        graphicsContext.fillPolygon(xCoords, yCoords, 3);
        graphicsContext.strokePolygon(xCoords, yCoords, 3);

        graphicsContext.restore();
    }
}
