package by.bsuir.ptoop.runner;

import by.bsuir.ptoop.gui.MainController;
import by.bsuir.ptoop.model.Color;
import by.bsuir.ptoop.model.exception.FigureCreationException;
import by.bsuir.ptoop.model.impl.*;
import by.bsuir.ptoop.util.FigureList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String FXML_FILE_PATH = "/fxml/main.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(FXML_FILE_PATH));

        MainController controller = loader.getController();
        controller.drawFigureList(createFigureList());

        stage.setTitle("PTOOP");
        stage.setScene(new Scene(root));
        stage.show();
    }

    private static FigureList createFigureList() {
        FigureList list = new FigureList();
        try {
            list.add(new Circle(Color.RED, Color.WHITE, 30, 100, 200));
            list.add(new Rectangle(Color.BLUE, Color.GREEN, 400, 100, 200, 250));
            list.add(new Point(Color.BLACK, 50, 50));
            list.add(new Line(Color.CYAN, 60, 60, 500, 350));
            list.add(new Ellipse(Color.MAGENTA, Color.YELLOW, 100, 200, 300, 150));
        } catch (FigureCreationException e) {
            e.printStackTrace();
        }
        return list;
    }
}
