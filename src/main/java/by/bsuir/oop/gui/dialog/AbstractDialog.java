package by.bsuir.oop.gui.dialog;

import by.bsuir.oop.model.Color;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.model.exception.FigureCreationException;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public abstract class AbstractDialog<T extends Figure> {

    protected Dialog<T> dialog;

    /**
     * Creates basic dialog with GridPane and uses overridden methods
     */
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

    /**
     * Implementations should set content to passed as parameter grid pane
     *
     * @param pane GridPane supposed to be set with controls
     */
    protected abstract void setContentToGridPane(GridPane pane);

    /**
     * Returns instance of some figure that must be created from controls stored in
     * implementations of AbstractDialog.
     *
     * @return successor of Figure
     * @throws FigureCreationException if invalid params passed to figure constructors
     */
    protected abstract T extractResult() throws FigureCreationException;

    /**
     * Shows dialog and waits until it will be closed
     *
     * @return Optional to result
     */
    public Optional<T> showAndWait() {
        return dialog.showAndWait();
    }

    /**
     * Extracts Color from colorPicker
     *
     * @param colorPicker ColorPicker
     * @return Color
     */
    protected Color getColorFromColorPicker(ColorPicker colorPicker) {
        return new Color(
                colorPicker.getValue().getRed(),
                colorPicker.getValue().getGreen(),
                colorPicker.getValue().getBlue()
        );
    }

    /**
     * Handy method to add control like ColorPicker or TextField to GridPane
     *
     * @param pane GridPane
     * @param rowNum row number
     * @param label text displayed in label
     * @param node control (ColorPicker or TextField)
     */
    protected void addRowToGrid(GridPane pane, int rowNum, String label, Node node) {
        pane.add(new Label(label + ":"), 0, rowNum);
        pane.add(node, 1, rowNum);
    }

}
