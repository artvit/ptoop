package by.bsuir.oop.gui.editor;

import by.bsuir.oop.gui.dialog.RectangleDialog;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Rectangle;

import java.util.Optional;

public class RectangleEditor extends AbstractChainEditor {
    @Override
    public boolean supports(Figure figure) {
        return figure instanceof Rectangle;
    }

    @Override
    protected Figure editFigure(Figure figure) {
        Optional<Rectangle> optionalRectangle = new RectangleDialog((Rectangle)figure).showAndWait();
        return optionalRectangle.orElse(null);
    }
}
