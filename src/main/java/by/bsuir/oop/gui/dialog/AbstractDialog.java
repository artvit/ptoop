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
        initDialog();
        GridPane grid = initGrid();
        setContentToGridPane(grid);
        dialog.getDialogPane().setContent(grid);
    }

    public AbstractDialog(T figure) {
        this();
        setFigureState(figure);
    }

    private void initDialog() {
        dialog = new Dialog<>();
        dialog.setTitle("Create Figure");
        dialog.setHeaderText("Enter data to create figure");

        ButtonType createButtonType = new ButtonType("Create", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButtonType, ButtonType.CANCEL);

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

    private GridPane initGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 10, 10));
        return grid;
    }



    /**
     * Implementations should set content to passed as parameter grid pane
     *
     * @param pane GridPane supposed to be set with controls
     */
    protected abstract void setContentToGridPane(GridPane pane);
    protected abstract void setFigureState(T figure);

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

    /**
     * Converts our model Color object to Color from JavaFX
     *
     * @param color Color from Figure
     * @return Color from JavaFX
     */
    protected javafx.scene.paint.Color getFxColor(by.bsuir.oop.model.Color color) {
        return javafx.scene.paint.Color.color(color.getRed(), color.getGreen(), color.getBlue());
    }
}
