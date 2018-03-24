package by.bsuir.oop.gui.dialog;

import by.bsuir.oop.model.Color;
import by.bsuir.oop.model.exception.FigureCreationException;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;
import java.util.regex.Pattern;

public abstract class AbstractDialog<T> {

    protected Dialog<T> dialog;

    public AbstractDialog() {
        dialog = new Dialog<>();
        dialog.setTitle("Create Figure");
        dialog.setHeaderText("Enter data to create figure");

        ButtonType createButtonType = new ButtonType("Create", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 10, 10));

        setContentToGridPane(grid);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButtonType) {
                try {
                    return extractResult();
                } catch (FigureCreationException e) {
                    e.printStackTrace();
                }
            }
            return null;
        });
    }

    protected abstract void setContentToGridPane(GridPane pane);

    protected abstract T extractResult() throws FigureCreationException;

    public Optional<T> showAndWait() {
        return dialog.showAndWait();
    }

    protected Color getColorFromColorPicker(ColorPicker colorPicker) {
        return new Color(
                colorPicker.getValue().getRed(),
                colorPicker.getValue().getGreen(),
                colorPicker.getValue().getBlue()
        );
    }

    protected void addRowToGrid(GridPane pane, int rowNum, String label, Node node) {
        pane.add(new Label(label + ":"), 0, rowNum);
        pane.add(node, 1, rowNum);
    }

}
