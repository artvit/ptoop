package by.bsuir.oop.gui.drawer;

import by.bsuir.oop.gui.DrawerException;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Rectangle;
import javafx.scene.paint.Color;

public class RectangleDrawer extends FigureDrawer {
    @Override
    public void draw(Figure figure) {
        if (figure instanceof Rectangle) {
            drawRectangle((Rectangle)figure);
        } else if (getNextFigureDrawer() != null) {
            getNextFigureDrawer().draw(figure);
        } else {
            throw new DrawerException("Unsupported figure passed to drawer");
        }
    }

    private void drawRectangle(Rectangle rectangle) {
        Color fxStrokeColor = getFxColor(rectangle.getColor());
        Color fxFillColor = getFxColor(rectangle.getFillColor());

        graphicsContext.save();

        graphicsContext.setStroke(fxStrokeColor);
        graphicsContext.setFill(fxFillColor);
        graphicsContext.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        graphicsContext.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());

        graphicsContext.restore();
    }
}
