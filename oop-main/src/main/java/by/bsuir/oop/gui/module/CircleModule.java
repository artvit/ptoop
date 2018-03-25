package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.dialog.CircleDialog;
import by.bsuir.oop.gui.editor.AbstractChainEditor;
import by.bsuir.oop.gui.editor.CircleEditor;
import by.bsuir.oop.model.Circle;

public class CircleModule extends AbstractModule<Circle> {


    @Override
    public AbstractChainEditor getEditor() {
        return new CircleEditor();
    }

    @Override
    public CircleDialog getDialog() {
        return new CircleDialog();
    }

    @Override
    public String getMenuItemTitle() {
        return "Circle";
    }
}
