package by.bsuir.oop.runner;

import by.bsuir.oop.gui.TableController;
import by.bsuir.oop.gui.module.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import by.bsuir.oop.gui.module.*;

import java.util.List;

public class TableMain extends Application {

    private static final String FXML_FILE_PATH = "/fxml/main-table.fxml";

    private static final List<AbstractModule> MODULE_LIST = List.of(
            new PointModule(),
            new LineModule(),
            new RectangleModule(),
            new TriangleModule(),
            new CircleModule(),
            new EllipseModule()
    );

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(FXML_FILE_PATH));

        TableController controller = loader.getController();
        controller.setStage(stage);
        MODULE_LIST.forEach(controller::addModule);

        stage.setTitle("OOP");
        stage.setScene(new Scene(root));
        stage.show();
    }
}