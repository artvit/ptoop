package by.bsuir.oop.gui.editor;

import by.bsuir.oop.gui.dialog.EllipseDialog;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Ellipse;

import java.util.Optional;

public class EllipseEditor extends AbstractChainEditor {
    @Override
    protected boolean supports(Figure figure) {
        return figure instanceof Ellipse;
    }

    @Override
    protected Figure editFigure(Figure figure) {
        Optional<Ellipse> optionalEllipse = new EllipseDialog((Ellipse)figure).showAndWait();
        return optionalEllipse.orElse(null);
    }
}
