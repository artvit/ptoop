package by.bsuir.oop.gui.table;

import by.bsuir.oop.model.Figure;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Class describes data row in table
 */
public class Row {
    private BooleanProperty checked;
    private ObjectProperty<Figure> figure;

    public Row(boolean checked, Figure figure) {
        this.checked = new SimpleBooleanProperty(checked);
        this.figure = new SimpleObjectProperty<>(figure);
    }

    public BooleanProperty checkedProperty() {
        return checked;
    }

    public boolean isChecked() {
        return checked.get();
    }

    public void setChecked(boolean checked) {
        this.checked.set(checked);
    }

    public ObjectProperty<Figure> figureProperty() {
        return figure;
    }

    public Figure getFigure() {
        return figure.get();
    }

    public void setFigure(Figure figure) {
        this.figure.set(figure);
    }
}
