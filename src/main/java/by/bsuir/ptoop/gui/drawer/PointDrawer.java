package by.bsuir.ptoop.gui.drawer;

import by.bsuir.ptoop.gui.DrawerException;
import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.impl.Point;
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
