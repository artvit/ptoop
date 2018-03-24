package by.bsuir.oop.gui.dialog;

import by.bsuir.oop.model.Color;
import by.bsuir.oop.model.exception.FigureCreationException;
import by.bsuir.oop.model.impl.Point;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PointDialog extends AbstractDialog<Point> {
    private ColorPicker colorPicker;
    private TextField xTextField;
    private TextField yTextField;

    @Override
    protected void setContentToGridPane(GridPane pane) {
        colorPicker = new ColorPicker();
        xTextField = new TextField();
        yTextField = new TextField();

        addRowToGrid(pane, 0, "Color", colorPicker);
        addRowToGrid(pane, 1, "X", xTextField);
        addRowToGrid(pane, 2, "Y", yTextField);
    }

    @Override
    protected Point extractResult() throws FigureCreationException {
        double x = Double.parseDouble(xTextField.getText());
        double y = Double.parseDouble(yTextField.getText());
        Color color = getColorFromColorPicker(colorPicker);
        return new Point(color, x, y);
    }
}
