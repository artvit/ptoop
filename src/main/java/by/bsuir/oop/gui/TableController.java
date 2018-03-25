package by.bsuir.oop.gui;

import by.bsuir.oop.gui.dialog.AbstractDialog;
import by.bsuir.oop.gui.editor.AbstractChainEditor;
import by.bsuir.oop.gui.module.AbstractModule;
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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TableController {
    @FXML private Menu addMenu;
    @FXML private Menu editMenu;
    @FXML private Menu serializeMenu;

    @FXML private TableView<Row> table;
    @FXML private TableColumn<Row, Boolean> checkboxColumn;
    @FXML private TableColumn<Row, String> valueColumn;

    private ObjectMapper objectMapper;
    private AbstractChainEditor editor;
    private ObservableList<Row> data;

    private Stage stage;

    @FXML
    public void initialize() {
        initTableView();
        initEditMenu();
        initSerializeMenu();
        objectMapper = new ObjectMapper(new BsonFactory());
        objectMapper.enableDefaultTyping();
    }


    public void addFigure(Figure figure) {
        data.add(new Row(false, figure));
    }

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

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void initTableView() {
        checkboxColumn.setCellFactory(CheckBoxTableCell.forTableColumn(checkboxColumn));
        checkboxColumn.setCellValueFactory(param -> param.getValue().checkedProperty());

        valueColumn.setCellValueFactory(new PropertyValueFactory<>("figure"));

        data = FXCollections.observableArrayList();
        table.setItems(data);
        table.setEditable(true);
    }

    private void initEditMenu() {
        MenuItem deleteMenuItem = new MenuItem("Delete Selected");
        deleteMenuItem.setOnAction(event -> {
            List<Row> toBeRemoved = data.filtered(Row::isChecked);
            data.removeAll(toBeRemoved);
        });
        editMenu.getItems().add(deleteMenuItem);

        MenuItem editMenuItem = new MenuItem("Edit Active Row");
        editMenuItem.setOnAction(event -> {
            Row selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Figure editedFigure = editor.edit(selected.getFigure());
                selected.setFigure(editedFigure);
            }
        });
        editMenu.getItems().add(editMenuItem);
    }

    private void initSerializeMenu() {
        MenuItem serializeMenuItem = new MenuItem("Serialize");
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
        serializeMenu.getItems().add(serializeMenuItem);
        MenuItem deserializeMenuItem = new MenuItem("Deserialize");
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
        serializeMenu.getItems().add(deserializeMenuItem);
    }

    private FileChooser getBsonFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("BSON files (*.bson)", "*.bson"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Any files", "*"));
        return fileChooser;
    }

}
