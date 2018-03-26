package by.bsuir.oop.gui;

import by.bsuir.oop.gui.dialog.AbstractDialog;
import by.bsuir.oop.gui.editor.AbstractChainEditor;
import by.bsuir.oop.gui.module.AbstractModule;
import by.bsuir.oop.gui.module.FunctionalModule;
import by.bsuir.oop.gui.module.Processor;
import by.bsuir.oop.gui.table.Row;
import by.bsuir.oop.model.Figure;
import by.bsuir.oop.util.FigureList;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.undercouch.bson4jackson.BsonFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TableController {
    @FXML private Menu addMenu;
    @FXML private Menu editMenu;
    @FXML private Menu fileMenu;
    @FXML private Menu optionsMenu;

    @FXML private TableView<Row> table;
    @FXML private TableColumn<Row, Boolean> checkboxColumn;
    @FXML private TableColumn<Row, String> valueColumn;

    private ObjectMapper objectMapper;
    private AbstractChainEditor editor;
    private ObservableList<Row> data;
    private Stage stage;

    private List<Processor> saveProcessors;
    private List<Processor> loadProcessors;

    @FXML
    public void initialize() {
        initFileMenu();
        initTableView();
        initEditMenu();
        initOptionsMenu();

        objectMapper = new ObjectMapper(new BsonFactory());
        objectMapper.enableDefaultTyping();

        saveProcessors = new LinkedList<>();
        loadProcessors = new LinkedList<>();
    }

    /**
     * Adds figure info to table
     * @param figure object of Figure subclass
     */
    public void addFigure(Figure figure) {
        data.add(new Row(false, figure));
    }

    /**
     * Adds MenuItem to Add menu and adds editor to chain
     *
     * @param module module that provides dialog and editor
     */
    public void addModule(AbstractModule<Figure> module) {
        AbstractChainEditor moduleEditor = module.getEditor();
        moduleEditor.setNext(editor);
        editor = moduleEditor;

        MenuItem item = new MenuItem(module.getMenuItemTitle());
        item.setOnAction(event -> {
            AbstractDialog<Figure> dialog = module.getDialog();
            Optional<Figure> figureOptional = dialog.showAndWait();
            figureOptional.ifPresent(this::addFigure);
        });
        addMenu.getItems().add(item);
    }

    /**
     * Sets stage (needed for FileChooser)
     *
     * @param stage parent stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Initializes table columns and row list
     */
    private void initTableView() {
        checkboxColumn.setCellFactory(CheckBoxTableCell.forTableColumn(checkboxColumn));
        checkboxColumn.setCellValueFactory(param -> param.getValue().checkedProperty());

        valueColumn.setCellValueFactory(new PropertyValueFactory<>("figure"));

        data = FXCollections.observableArrayList();
        table.setItems(data);
        table.setEditable(true);
    }

    /**
     * Adds Items to edit menu
     */
    private void initEditMenu() {
        MenuItem deleteMenuItem = new MenuItem("Delete Selected");
        deleteMenuItem.setOnAction(event -> {
            List<Row> toBeRemoved = data.filtered(Row::isChecked);
            data.removeAll(toBeRemoved);
        });
        editMenu.getItems().add(deleteMenuItem);

        MenuItem editMenuItem = new MenuItem("Edit active row...");
        editMenuItem.setOnAction(event -> {
            Row selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Figure editedFigure = editor.edit(selected.getFigure());
                selected.setFigure(editedFigure);
            }
        });
        editMenu.getItems().add(editMenuItem);
    }

    /**
     * Adds items to serialization menu
     */
    private void initFileMenu() {
        MenuItem serializeMenuItem = new MenuItem("Save selected...");
        serializeMenuItem.setOnAction(event -> {
            List<Figure> toBeSerialized = data
                    .filtered(Row::isChecked)
                    .stream()
                    .map(Row::getFigure)
                    .collect(Collectors.toList());
            toBeSerialized = new FigureList(toBeSerialized);
            FileChooser fileChooser = getBsonFileChooser();
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                if(!file.getName().contains(".")) {
                    file = new File(file.getAbsolutePath() + ".bson");
                }
                try (OutputStream outputStream = new FileOutputStream(file)) {
                    objectMapper.writeValue(outputStream, toBeSerialized);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        fileMenu.getItems().add(serializeMenuItem);
        MenuItem deserializeMenuItem = new MenuItem("Load...");
        deserializeMenuItem.setOnAction(event -> {
            FileChooser fileChooser = getBsonFileChooser();
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                try (InputStream inputStream = new FileInputStream(file)) {
                    List<Figure> list = objectMapper.readValue(inputStream, new TypeReference<FigureList>(){});
                    list.forEach(this::addFigure);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        fileMenu.getItems().add(deserializeMenuItem);
    }

    /**
     * Initializes options menu
     */
    private void initOptionsMenu() {
        MenuItem loadPluginMenuItem = new MenuItem("Load plugin...");
        loadPluginMenuItem.setOnAction(event -> {
            Optional<String> classNameOptional = openDialogToGetClassName();
            classNameOptional.ifPresent(this::loadModule);
        });
        optionsMenu.getItems().add(loadPluginMenuItem);

        MenuItem loadOnLoadPluginMenuItem = new MenuItem("Load On Load plugin...");
        loadOnLoadPluginMenuItem.setOnAction(event -> {
            Optional<String> classNameOptional = openDialogToGetClassName();
            classNameOptional.ifPresent(this::loadOnLoadModule);
        });
        optionsMenu.getItems().add(loadOnLoadPluginMenuItem);

        MenuItem loadOnSavePluginMenuItem = new MenuItem("Load On Save plugin...");
        loadOnSavePluginMenuItem.setOnAction(event -> {
            Optional<String> classNameOptional = openDialogToGetClassName();
            classNameOptional.ifPresent(this::loadOnSaveModule);
        });
        optionsMenu.getItems().add(loadOnSavePluginMenuItem);
    }

    /**
     * Creates file chooser dialog for BSON files
     *
     * @return FileChooser
     */
    private FileChooser getBsonFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("BSON files (*.bson)", "*.bson"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Any files", "*"));
        return fileChooser;
    }

    /**
     * Opens dialog to get class name
     *
     * @return Optional object which should contain class name
     */
    private Optional<String> openDialogToGetClassName() {
        TextInputDialog dialog = new TextInputDialog("by.bsuir.oop.gui.module.RoundRectangleModule");
        dialog.setTitle("Module Class");
        dialog.setHeaderText("Specify full module class name");
        dialog.setContentText("Class:");
        return dialog.showAndWait();
    }

    /**
     * Load module buy class name
     *
     * @param className full name of module class
     */
    private void loadModule(String className) {
        try {
            Class<AbstractModule<Figure>> moduleClass = (Class<AbstractModule<Figure>>)Class.forName(className);
            Constructor<AbstractModule<Figure>> constructor = moduleClass.getConstructor();
            AbstractModule<Figure> module = constructor.newInstance();
            addModule(module);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void loadOnSaveModule(String className) {
        saveProcessors.add(loadProcessor(className));
    }

    private void loadOnLoadModule(String className) {
        loadProcessors.add(loadProcessor(className));
    }

    private Processor loadProcessor(String moduleName) {
        try {
            Class<FunctionalModule> moduleClass = (Class<FunctionalModule>)Class.forName(moduleName);
            Constructor<FunctionalModule> constructor = moduleClass.getConstructor();
            FunctionalModule module = constructor.newInstance();
            return module.getProcessor();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
