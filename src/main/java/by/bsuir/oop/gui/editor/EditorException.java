package by.bsuir.oop.gui.editor;

public class EditorException extends RuntimeException {
    public EditorException() {
    }

    public EditorException(String message) {
        super(message);
    }

    public EditorException(String message, Throwable cause) {
        super(message, cause);
    }

    public EditorException(Throwable cause) {
        super(cause);
    }
}
