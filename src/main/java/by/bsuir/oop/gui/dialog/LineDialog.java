package by.bsuir.oop.gui.dialog;

import by.bsuir.oop.model.Color;
import by.bsuir.oop.model.exception.FigureCreationException;
import by.bsuir.oop.model.impl.Line;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LineDialog extends AbstractDialog<Line> {
    private ColorPicker colorPicker;
    private TextField startXTextField;
    private TextField startYTextField;
    private TextField endXTextField;
    private TextField endYTextField;

    @Override
    protected void setContentToGridPane(GridPane pane) {
        colorPicker = new ColorPicker();
        startXTextField = new TextField();
        startYTextField = new TextField();
        endXTextField = new TextField();
        endYTextField = new TextField();

        addRowToGrid(pane, 0, "Color", colorPicker);
        addRowToGrid(pane, 1, "Start X", startXTextField);
        addRowToGrid(pane, 2, "Start Y", startYTextField);
        addRowToGrid(pane, 3, "End X", endXTextField);
        addRowToGrid(pane, 4, "End Y", endYTextField);
    }

    @Override
    protected Line extractResult() throws FigureCreationException {
        double x = Double.parseDouble(startXTextField.getText());
        double y = Double.parseDouble(startYTextField.getText());
        double endX = Double.parseDouble(endXTextField.getText());
        double endY = Double.parseDouble(endYTextField.getText());
        Color color = getColorFromColorPicker(colorPicker);
        return new Line(color, x, y, endX, endY);
    }
}
