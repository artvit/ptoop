package by.bsuir.oop.gui.dialog;

import by.bsuir.oop.model.Color;
import by.bsuir.oop.model.exception.FigureCreationException;
import by.bsuir.oop.model.impl.Rectangle;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class RectangleDialog extends AbstractDialog<Rectangle> {
    private ColorPicker colorPicker;
    private ColorPicker fillColorPicker;
    private TextField xTextField;
    private TextField yTextField;
    private TextField widthTextField;
    private TextField heightTextField;

    public RectangleDialog() {
    }

    public RectangleDialog(Rectangle figure) {
        super(figure);
    }

    @Override
    protected void setContentToGridPane(GridPane pane) {
        colorPicker = new ColorPicker();
        fillColorPicker = new ColorPicker();
        xTextField = new TextField();
        yTextField = new TextField();
        widthTextField = new TextField();
        heightTextField = new TextField();

        addRowToGrid(pane, 0, "Color", colorPicker);
        addRowToGrid(pane, 1, "Fill Color", fillColorPicker);
        addRowToGrid(pane, 2, "X", xTextField);
        addRowToGrid(pane, 3, "Y", yTextField);
        addRowToGrid(pane, 4, "Width", widthTextField);
        addRowToGrid(pane, 5, "Height", heightTextField);
    }

    @Override
    protected void setFigureState(Rectangle figure) {
        colorPicker.setValue(getFxColor(figure.getColor()));
        fillColorPicker.setValue(getFxColor(figure.getFillColor()));
        xTextField.textProperty().setValue(Double.toString(figure.getX()));
        yTextField.textProperty().setValue(Double.toString(figure.getY()));
        widthTextField.textProperty().setValue(Double.toString(figure.getWidth()));
        heightTextField.textProperty().setValue(Double.toString(figure.getHeight()));
    }

    @Override
    protected Rectangle extractResult() throws FigureCreationException {
        double x = Double.parseDouble(xTextField.getText());
        double y = Double.parseDouble(yTextField.getText());
        double width = Double.parseDouble(widthTextField.getText());
        double height = Double.parseDouble(heightTextField.getText());
        Color color = getColorFromColorPicker(colorPicker);
        Color fillColor = getColorFromColorPicker(fillColorPicker);
        return new Rectangle(color, fillColor, x, y, height, width);
    }
}
