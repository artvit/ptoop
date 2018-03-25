package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.dialog.EllipseDialog;
import by.bsuir.oop.gui.editor.EllipseEditor;
import by.bsuir.oop.model.Ellipse;

public class EllipseModule extends AbstractModule<Ellipse> {
    @Override
    public EllipseEditor getEditor() {
        return new EllipseEditor();
    }

    @Override
    public EllipseDialog getDialog() {
        return new EllipseDialog();
    }

    @Override
    public String getMenuItemTitle() {
        return "Ellipse";
    }
}
