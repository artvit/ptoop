package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.dialog.PointDialog;
import by.bsuir.oop.gui.drawer.PointDrawer;
import by.bsuir.oop.model.impl.Point;


public class PointModule extends AbstractModule<Point> {
    @Override
    public PointDrawer getFigureDrawer() {
        return new PointDrawer();
    }

    @Override
    protected PointDialog getDialog() {
        return new PointDialog();
    }

    @Override
    protected String getMenuItemTitle() {
        return "Draw Point";
    }
}
