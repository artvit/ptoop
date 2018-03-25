package by.bsuir.oop.gui.editor;

import by.bsuir.oop.model.Figure;

public abstract class AbstractChainEditor {
    private AbstractChainEditor next;

    public Figure edit(Figure figure) {
        if (supports(figure)) {
            return editFigure(figure);
        } else if (getNext() != null) {
            return getNext().edit(figure);
        } else {
            throw new EditorException("Unsupported figure passed to editor");
        }
    }

    protected abstract boolean supports(Figure figure);
    protected abstract Figure editFigure(Figure figure);

    private AbstractChainEditor getNext() {
        return next;
    }

    public void setNext(AbstractChainEditor next) {
        this.next = next;
    }
}
