package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.dialog.LineDialog;
import by.bsuir.oop.gui.drawer.LineDrawer;
import by.bsuir.oop.model.impl.Line;

public class LineModule extends AbstractModule<Line> {
    @Override
    public LineDrawer getFigureDrawer() {
        return new LineDrawer();
    }

    @Override
    protected LineDialog getDialog() {
        return new LineDialog();
    }

    @Override
    protected String getMenuItemTitle() {
        return "Draw Line";
    }
}
