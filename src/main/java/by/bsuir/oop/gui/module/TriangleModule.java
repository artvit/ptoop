package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.dialog.TriangleDialog;
import by.bsuir.oop.gui.drawer.TriangleDrawer;
import by.bsuir.oop.model.impl.Triangle;

public class TriangleModule extends AbstractModule<Triangle> {
    @Override
    public TriangleDrawer getFigureDrawer() {
        return new TriangleDrawer();
    }

    @Override
    protected TriangleDialog getDialog() {
        return new TriangleDialog();
    }

    @Override
    protected String getMenuItemTitle() {
        return "Draw Triangle";
    }
}
