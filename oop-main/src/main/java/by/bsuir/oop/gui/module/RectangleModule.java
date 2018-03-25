package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.dialog.RectangleDialog;
import by.bsuir.oop.gui.editor.RectangleEditor;
import by.bsuir.oop.model.impl.Rectangle;

public class RectangleModule extends AbstractModule<Rectangle> {
    @Override
    public RectangleEditor getEditor() {
        return new RectangleEditor();
    }

    @Override
    public RectangleDialog getDialog() {
        return new RectangleDialog();
    }

    @Override
    public String getMenuItemTitle() {
        return "Rectangle";
    }
}
