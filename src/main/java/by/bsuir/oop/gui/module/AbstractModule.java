package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.Drawer;
import by.bsuir.oop.gui.dialog.AbstractDialog;
import by.bsuir.oop.gui.drawer.FigureDrawer;
import by.bsuir.oop.model.Figure;
import javafx.scene.control.MenuItem;

import java.util.Optional;

public abstract class AbstractModule<T extends Figure> {
    private Drawer drawer;

    public AbstractModule() {
    }

    /**
     * Initialize module with drawer
     *
     * @param drawer Drawer object
     */
    public void init(Drawer drawer) {
        this.drawer = drawer;
    }

    public MenuItem getMenuItem() {
        MenuItem item = new MenuItem(getMenuItemTitle());
        item.setOnAction(event -> {
            AbstractDialog<T> dialog = getDialog();
            Optional<T> figureOptional = dialog.showAndWait();
            figureOptional.ifPresent(figure -> drawer.drawFigure(figure));
        });
        return item;
    }

    /**
     * Returns FigureDrawer implementation
     *
     * @return FigureDrawer successor
     */
    public abstract FigureDrawer getFigureDrawer();

    /**
     * Returns AbstractDialog implementation
     *
     * @return AbstractDialog successor
     */
    protected abstract AbstractDialog<T> getDialog();

    /**
     * Returns title which will be displayed in menu
     *
     * @return title
     */
    protected abstract String getMenuItemTitle();

}
