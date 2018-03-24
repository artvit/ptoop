package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.dialog.RectangleDialog;
import by.bsuir.oop.gui.drawer.RectangleDrawer;
import by.bsuir.oop.model.impl.Rectangle;

public class RectangleModule extends AbstractModule<Rectangle> {
    @Override
    public RectangleDrawer getFigureDrawer() {
        return new RectangleDrawer();
    }

    @Override
    protected RectangleDialog getDialog() {
        return new RectangleDialog();
    }

    @Override
    protected String getMenuItemTitle() {
        return "Draw Rectangle";
    }
}
