package by.bsuir.oop.gui.drawer;

import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Point;
import javafx.scene.paint.Color;

public class PointDrawer extends FigureDrawer {
    @Override
    public boolean supports(Figure figure) {
        return figure instanceof Point;
    }


    @Override
    public void drawFigure(Figure figure) {
        Point line = (Point) figure;
        drawPoint(line);
    }

    private void drawPoint(Point point) {
        Color fxStrokeColor = getFxColor(point.getColor());

        graphicsContext.save();

        graphicsContext.setStroke(fxStrokeColor);
        graphicsContext.strokeOval(point.getX(),point.getY() , 1, 1);

        graphicsContext.restore();
    }
}
