package by.bsuir.oop.gui.editor;

import by.bsuir.oop.gui.dialog.CircleDialog;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Circle;

import java.util.Optional;

public class CircleEditor extends AbstractChainEditor {

    @Override
    protected boolean supports(Figure figure) {
        return figure instanceof Circle;
    }

    @Override
    protected Figure editFigure(Figure figure) {
        Optional<Circle> optionalCircle = new CircleDialog((Circle)figure).showAndWait();
        return optionalCircle.orElse(null);
    }
}
