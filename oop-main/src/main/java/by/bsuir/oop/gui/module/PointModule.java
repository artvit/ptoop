package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.dialog.PointDialog;
import by.bsuir.oop.gui.editor.PointEditor;
import by.bsuir.oop.model.Point;


public class PointModule extends AbstractModule<Point> {
    @Override
    public PointEditor getEditor() {
        return new PointEditor();
    }

    @Override
    public PointDialog getDialog() {
        return new PointDialog();
    }

    @Override
    public String getMenuItemTitle() {
        return "Point";
    }
}
