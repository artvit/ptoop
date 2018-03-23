package by.bsuir.oop.gui.drawer;

import by.bsuir.oop.gui.DrawerException;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Line;
import javafx.scene.paint.Color;

public class LineDrawer extends FigureDrawer {
    @Override
    public void draw(Figure figure) {
        if (figure instanceof Line) {
            drawLine((Line)figure);
        } else if (getNextFigureDrawer() != null) {
            getNextFigureDrawer().draw(figure);
        } else {
            throw new DrawerException("Unsupported figure passed to drawer");
        }
    }

    private void drawLine(Line line) {
        Color fxStrokeColor = getFxColor(line.getColor());

        graphicsContext.save();

        graphicsContext.setStroke(fxStrokeColor);
        graphicsContext.strokeLine(line.getStartX(),line.getStartY(), line.getEndX(), line.getEndY());

        graphicsContext.restore();
    }
}
