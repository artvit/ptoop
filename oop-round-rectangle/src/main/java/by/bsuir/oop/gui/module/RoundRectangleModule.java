package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.dialog.AbstractDialog;
import by.bsuir.oop.gui.dialog.RoundRectangleDialog;
import by.bsuir.oop.gui.editor.AbstractChainEditor;
import by.bsuir.oop.gui.editor.RoundRectangleEditor;
import by.bsuir.oop.model.RoundRectangle;

public class RoundRectangleModule extends AbstractModule<RoundRectangle> {
    @Override
    public AbstractChainEditor getEditor() {
        return new RoundRectangleEditor();
    }

    @Override
    public AbstractDialog<RoundRectangle> getDialog() {
        return new RoundRectangleDialog();
    }

    @Override
    public String getMenuItemTitle() {
        return "Round Rectangle";
    }
}
