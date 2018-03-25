package by.bsuir.oop.gui.module;

import by.bsuir.oop.gui.dialog.AbstractDialog;
import by.bsuir.oop.gui.editor.AbstractChainEditor;
import by.bsuir.oop.model.Figure;

public abstract class AbstractModule<T extends Figure> { ;

    public AbstractModule() {
    }

    /**
     * Returns FigureDrawer implementation
     *
     * @return FigureDrawer successor
     */
    public abstract AbstractChainEditor getEditor();

    /**
     * Returns AbstractDialog implementation
     *
     * @return AbstractDialog successor
     */
    public abstract AbstractDialog<T> getDialog();

    /**
     * Returns title which will be displayed in menu
     *
     * @return title
     */
    public abstract String getMenuItemTitle();

}
