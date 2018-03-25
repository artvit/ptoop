package by.bsuir.oop.gui.editor;

import by.bsuir.oop.gui.dialog.PointDialog;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Point;
import javafx.scene.paint.Color;

import java.util.Optional;

public class PointEditor extends AbstractChainEditor {
    @Override
    public boolean supports(Figure figure) {
        return figure instanceof Point;
    }

    @Override
    protected Figure editFigure(Figure figure) {
        Optional<Point> optionalPoint = new PointDialog((Point)figure).showAndWait();
        return optionalPoint.orElse(null);
    }

}
