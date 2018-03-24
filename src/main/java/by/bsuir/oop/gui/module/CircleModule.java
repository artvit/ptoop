package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.dialog.CircleDialog;
import by.bsuir.oop.gui.drawer.CircleDrawer;
import by.bsuir.oop.model.impl.Circle;

public class CircleModule extends AbstractModule<Circle> {
    @Override
    public CircleDrawer getFigureDrawer() {
        return new CircleDrawer();
    }

    @Override
    protected CircleDialog getDialog() {
        return new CircleDialog();
    }

    @Override
    protected String getMenuItemTitle() {
        return "Draw Circle";
    }
}
