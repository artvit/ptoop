package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.dialog.TriangleDialog;
import by.bsuir.oop.gui.editor.TriangleEditor;
import by.bsuir.oop.model.impl.Triangle;

public class TriangleModule extends AbstractModule<Triangle> {
    @Override
    public TriangleEditor getEditor() {
        return new TriangleEditor();
    }

    @Override
    public TriangleDialog getDialog() {
        return new TriangleDialog();
    }

    @Override
    public String getMenuItemTitle() {
        return "Triangle";
    }
}
