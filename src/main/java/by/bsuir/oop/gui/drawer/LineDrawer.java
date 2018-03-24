package by.bsuir.oop.gui.drawer;

import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Line;
import javafx.scene.paint.Color;

public class LineDrawer extends FigureDrawer {
    @Override
    public boolean supports(Figure figure) {
        return figure instanceof Line;
    }

    @Override
    public void drawFigure(Figure figure) {
        Line line = (Line) figure;
        drawLine(line);
    }

    private void drawLine(Line line) {
        Color fxStrokeColor = getFxColor(line.getColor());

        graphicsContext.save();

        graphicsContext.setStroke(fxStrokeColor);
        graphicsContext.strokeLine(line.getStartX(),line.getStartY(), line.getEndX(), line.getEndY());

        graphicsContext.restore();
    }
}
