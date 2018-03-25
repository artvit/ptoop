package by.bsuir.oop.gui.editor;

import by.bsuir.oop.gui.dialog.LineDialog;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Line;

import java.util.Optional;

public class LineEditor extends AbstractChainEditor {
    @Override
    public boolean supports(Figure figure) {
        return figure instanceof Line;
    }

    @Override
    protected Figure editFigure(Figure figure) {
        Optional<Line> optionalLine = new LineDialog((Line)figure).showAndWait();
        return optionalLine.orElse(null);
    }
}
