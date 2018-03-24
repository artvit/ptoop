package by.bsuir.oop.gui.dialog;

import by.bsuir.oop.model.Color;
import by.bsuir.oop.model.exception.FigureCreationException;
import by.bsuir.oop.model.impl.Triangle;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TriangleDialog extends AbstractDialog<Triangle> {
    private ColorPicker colorPicker;
    private ColorPicker fillColorPicker;
    private TextField x1TextField;
    private TextField y1TextField;
    private TextField x2TextField;
    private TextField y2TextField;
    private TextField x3TextField;
    private TextField y3TextField;

    @Override
    protected void setContentToGridPane(GridPane pane) {
        colorPicker = new ColorPicker();
        fillColorPicker = new ColorPicker();
        x1TextField = new TextField();
        y1TextField = new TextField();
        x2TextField = new TextField();
        y2TextField = new TextField();
        x3TextField = new TextField();
        y3TextField = new TextField();

        addRowToGrid(pane, 0, "Color", colorPicker);
        addRowToGrid(pane, 1, "Fill Color", fillColorPicker);
        addRowToGrid(pane, 2, "Point 1 X", x1TextField);
        addRowToGrid(pane, 3, "Point 1 Y", y1TextField);
        addRowToGrid(pane, 4, "Point 2 X", x2TextField);
        addRowToGrid(pane, 5, "Point 2 Y", y2TextField);
        addRowToGrid(pane, 6, "Point 3 X", x3TextField);
        addRowToGrid(pane, 7, "Point 3 Y", y3TextField);
    }

    @Override
    protected Triangle extractResult() throws FigureCreationException {
        double x1 = Double.parseDouble(x1TextField.getText());
        double y1 = Double.parseDouble(y1TextField.getText());
        double x2 = Double.parseDouble(x2TextField.getText());
        double y2 = Double.parseDouble(y2TextField.getText());
        double x3 = Double.parseDouble(x3TextField.getText());
        double y3 = Double.parseDouble(y3TextField.getText());
        Color color = getColorFromColorPicker(colorPicker);
        Color fillColor = getColorFromColorPicker(fillColorPicker);
        return new Triangle(color, fillColor, x1, y1, x2, y2, x3, y3);
    }
}
