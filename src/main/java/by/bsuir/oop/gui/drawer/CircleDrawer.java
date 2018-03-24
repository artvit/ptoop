package by.bsuir.oop.gui.drawer;

import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Circle;
import javafx.scene.paint.Color;

public class CircleDrawer extends FigureDrawer {

    @Override
    public boolean supports(Figure figure) {
        return figure instanceof Circle;
    }


    @Override
    public void drawFigure(Figure figure) {
        Circle line = (Circle) figure;
        drawCircle(line);
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
