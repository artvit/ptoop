package by.bsuir.oop.gui.editor;

import by.bsuir.oop.gui.dialog.RoundRectangleDialog;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.RoundRectangle;

import java.util.Optional;

public class RoundRectangleEditor extends AbstractChainEditor {

    @Override
    protected boolean supports(Figure figure) {
        return figure instanceof RoundRectangle;
    }

    @Override
    protected Figure editFigure(Figure figure) {
        Optional<RoundRectangle> optionalRoundRectangle = new RoundRectangleDialog((RoundRectangle)figure).showAndWait();
        return optionalRoundRectangle.orElse(null);
    }
}
