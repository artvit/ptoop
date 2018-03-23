package by.bsuir.oop.gui.drawer;

import by.bsuir.oop.gui.DrawerException;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Ellipse;
import javafx.scene.paint.Color;

public class EllipseDrawer extends FigureDrawer{
    @Override
    public void draw(Figure figure) {
        if (figure instanceof Ellipse) {
            drawEllipse((Ellipse)figure);
        } else if (getNextFigureDrawer() != null) {
            getNextFigureDrawer().draw(figure);
        } else {
            throw new DrawerException("Unsupported figure passed to drawer");
        }
    }

    private void drawEllipse(Ellipse ellipse) {
        double leftUpperCornerX = ellipse.getCenterX() - ellipse.getRadius();
        double leftUpperCornerY = ellipse.getCenterY() - ellipse.getRadius();
        double width = ellipse.getHorizontalRadius() * 2;
        double height = ellipse.getRadius() * 2;

        Color fxStrokeColor = getFxColor(ellipse.getColor());
        Color fxFillColor = getFxColor(ellipse.getFillColor());

        graphicsContext.save();

        graphicsContext.setStroke(fxStrokeColor);
        graphicsContext.setFill(fxFillColor);
        graphicsContext.fillOval(leftUpperCornerX, leftUpperCornerY, width, height);
        graphicsContext.strokeOval(leftUpperCornerX, leftUpperCornerY, width, height);

        graphicsContext.restore();
    }
}
