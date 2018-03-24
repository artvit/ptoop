package by.bsuir.oop.runner;

import by.bsuir.oop.gui.MainController;
import by.bsuir.oop.gui.module.*;
import by.bsuir.oop.model.Color;
import by.bsuir.oop.model.exception.FigureCreationException;
import by.bsuir.oop.model.impl.*;
import by.bsuir.oop.util.FigureList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    private static final String FXML_FILE_PATH = "/fxml/main.fxml";

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

        MainController controller = loader.getController();
        MODULE_LIST.forEach(module -> {
            controller.getDrawer().addDrawer(module.getFigureDrawer());
            module.init(controller.getDrawer());
            controller.addMenuItem(module.getMenuItem());
        });

//        controller.drawFigureList(createFigureList());

        stage.setTitle("OOP");
        stage.setScene(new Scene(root));
        stage.show();
    }


    /**
     * Returns Figure lists of Figure implementations
     *
     * @return FigureList
     */
    private static FigureList createFigureList() {
        FigureList list = new FigureList();
        try {
            list.add(new Circle(Color.RED, Color.WHITE, 30, 100, 200));
            list.add(new Rectangle(Color.BLUE, Color.GREEN, 400, 100, 200, 250));
            list.add(new Point(Color.BLACK, 50, 50));
            list.add(new Line(Color.CYAN, 60, 60, 500, 350));
            list.add(new Ellipse(Color.MAGENTA, Color.YELLOW, 100, 200, 300, 150));
            list.add(new Triangle(Color.MAGENTA, Color.CYAN, 200, 100, 380, 110, 250, 20));
        } catch (FigureCreationException e) {
            e.printStackTrace();
        }
        return list;
    }
}
