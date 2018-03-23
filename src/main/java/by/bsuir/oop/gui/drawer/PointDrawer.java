package by.bsuir.oop.gui.drawer;

import by.bsuir.oop.gui.DrawerException;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Point;
import javafx.scene.paint.Color;

public class PointDrawer extends FigureDrawer {
    @Override
    public void draw(Figure figure) {
        if (figure instanceof Point) {
            drawPoint((Point)figure);
        } else if (getNextFigureDrawer() != null) {
            getNextFigureDrawer().draw(figure);
        } else {
            throw new DrawerException("Unsupported figure passed to drawer");
        }
    }

    private void drawPoint(Point point) {
        Color fxStrokeColor = getFxColor(point.getColor());

        graphicsContext.save();

        graphicsContext.setStroke(fxStrokeColor);
        graphicsContext.strokeOval(point.getX(),point.getY() , 1, 1);

        graphicsContext.restore();
    }
}
