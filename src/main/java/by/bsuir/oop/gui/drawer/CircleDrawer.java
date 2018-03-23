package by.bsuir.oop.gui.drawer;

import by.bsuir.oop.gui.DrawerException;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Circle;
import javafx.scene.paint.Color;

public class CircleDrawer extends FigureDrawer {

    @Override
    public void draw(Figure figure) {
        if (figure instanceof Circle) {
            drawCircle((Circle)figure);
        } else if (getNextFigureDrawer() != null) {
            getNextFigureDrawer().draw(figure);
        } else {
            throw new DrawerException("Unsupported figure passed to drawer");
        }
    }

    private void drawCircle(Circle circle) {
        double leftUpperCornerX = circle.getCenterX() - circle.getRadius();
        double leftUpperCornerY = circle.getCenterY() - circle.getRadius();
        double diameter = circle.getRadius() * 2;

        Color fxStrokeColor = getFxColor(circle.getColor());
        Color fxFillColor = getFxColor(circle.getFillColor());

        graphicsContext.save();

        graphicsContext.setStroke(fxStrokeColor);
        graphicsContext.setFill(fxFillColor);
        graphicsContext.fillOval(leftUpperCornerX, leftUpperCornerY, diameter, diameter);
        graphicsContext.strokeOval(leftUpperCornerX, leftUpperCornerY, diameter, diameter);

        graphicsContext.restore();
    }
}
