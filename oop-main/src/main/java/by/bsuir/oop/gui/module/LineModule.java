package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.dialog.LineDialog;
import by.bsuir.oop.gui.editor.LineEditor;
import by.bsuir.oop.model.Line;

public class LineModule extends AbstractModule<Line> {
    @Override
    public LineEditor getEditor() {
        return new LineEditor();
    }

    @Override
    public LineDialog getDialog() {
        return new LineDialog();
    }

    @Override
    public String getMenuItemTitle() {
        return "Line";
    }
}
