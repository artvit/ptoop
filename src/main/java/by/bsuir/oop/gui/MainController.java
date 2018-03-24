package by.bsuir.oop.gui;

import by.bsuir.oop.util.FigureList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class MainController {
    @FXML private Canvas canvas;
    @FXML private Menu menu;

    private Drawer drawer;

    /**
     * Initialize MainController
     */
    @FXML public void initialize() {
        drawer = new Drawer(canvas);

    }

    /**
     * Draws figure list
     *
     * @param list FigureList
     */
    public void drawFigureList(FigureList list) {
        list.forEach(drawer::drawFigure);
    }

    /**
     * Returns drawer
     *
     * @return Drawer
     */
    public Drawer getDrawer() {
        return drawer;
    }

    /**
     * Adds menu item to Draw menu
     *
     * @param menuItem MenuItem
     */
    public void addMenuItem(MenuItem menuItem) {
        menu.getItems().add(menuItem);
    }
}
