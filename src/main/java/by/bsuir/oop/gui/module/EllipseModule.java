package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.dialog.EllipseDialog;
import by.bsuir.oop.gui.drawer.EllipseDrawer;
import by.bsuir.oop.model.impl.Ellipse;

public class EllipseModule extends AbstractModule<Ellipse> {
    @Override
    public EllipseDrawer getFigureDrawer() {
        return new EllipseDrawer();
    }

    @Override
    protected EllipseDialog getDialog() {
        return new EllipseDialog();
    }

    @Override
    protected String getMenuItemTitle() {
        return "Draw Ellipse";
    }
}
