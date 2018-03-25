package by.bsuir.oop.gui.editor;

import by.bsuir.oop.gui.dialog.TriangleDialog;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.impl.Triangle;
import javafx.scene.paint.Color;

import java.util.Optional;

public class TriangleEditor extends AbstractChainEditor {
    @Override
    public boolean supports(Figure figure) {
        return figure instanceof Triangle;
    }

    @Override
    protected Figure editFigure(Figure figure) {
        Optional<Triangle> optionalTriangle = new TriangleDialog((Triangle)figure).showAndWait();
        return optionalTriangle.orElse(null);
    }
}
