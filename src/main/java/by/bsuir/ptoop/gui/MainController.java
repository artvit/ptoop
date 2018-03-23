package by.bsuir.ptoop.gui;

import by.bsuir.ptoop.util.FigureList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public class MainController {
    @FXML private Canvas canvas;

    private Drawer drawer;

    @FXML public void initialize() {
        drawer = new Drawer(canvas);
    }

    public void drawFigureList(FigureList list) {
        list.forEach(drawer::drawFigure);
    }
}
