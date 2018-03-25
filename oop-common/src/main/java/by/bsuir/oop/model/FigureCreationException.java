package by.bsuir.oop.model;

public class FigureCreationException extends Exception {
    public FigureCreationException() {
    }

    public FigureCreationException(String message) {
        super(message);
    }

    public FigureCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public FigureCreationException(Throwable cause) {
        super(cause);
    }
}
