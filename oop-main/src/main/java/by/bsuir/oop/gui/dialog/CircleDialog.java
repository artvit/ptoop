package by.bsuir.oop.gui.dialog;

import by.bsuir.oop.model.Color;
import by.bsuir.oop.model.exception.FigureCreationException;
import by.bsuir.oop.model.impl.Circle;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CircleDialog extends AbstractDialog<Circle> {
    private ColorPicker colorPicker;
    private ColorPicker fillColorPicker;
    private TextField centerXTextField;
    private TextField centerYTextField;
    private TextField radiusTextField;

    public CircleDialog() {
    }

    public CircleDialog(Circle figure) {
        super(figure);
    }

    @Override
    protected void setContentToGridPane(GridPane pane) {
        colorPicker = new ColorPicker();
        fillColorPicker = new ColorPicker();
        centerXTextField = new TextField();
        centerYTextField = new TextField();
        radiusTextField = new TextField();

        addRowToGrid(pane, 0, "Color", colorPicker);
        addRowToGrid(pane, 1, "Fill Color", fillColorPicker);
        addRowToGrid(pane, 2, "Center X", centerXTextField);
        addRowToGrid(pane, 3, "Center Y", centerYTextField);
        addRowToGrid(pane, 4, "Radius", radiusTextField);
    }

    @Override
    protected void setFigureState(Circle figure) {
        colorPicker.setValue(getFxColor(figure.getColor()));
        fillColorPicker.setValue(getFxColor(figure.getFillColor()));
        centerXTextField.textProperty().setValue(Double.toString(figure.getCenterX()));
        centerYTextField.textProperty().setValue(Double.toString(figure.getCenterY()));
        radiusTextField.textProperty().setValue(Double.toString(figure.getRadius()));

    }

    @Override
    protected Circle extractResult() throws FigureCreationException {
        double x = Double.parseDouble(centerXTextField.getText());
        double y = Double.parseDouble(centerYTextField.getText());
        double radius = Double.parseDouble(radiusTextField.getText());
        Color color = getColorFromColorPicker(colorPicker);
        Color fillColor = getColorFromColorPicker(fillColorPicker);
        return new Circle(color, fillColor, radius, x, y);
    }
}
