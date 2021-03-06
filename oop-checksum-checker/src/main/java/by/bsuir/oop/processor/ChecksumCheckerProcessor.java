package by.bsuir.oop.processor;

import by.bsuir.oop.gui.module.Processor;
import by.bsuir.oop.util.Checksum;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class ChecksumCheckerProcessor implements Processor {

    private Checksum checksum;

    public ChecksumCheckerProcessor() {
        this.checksum = new Checksum();
    }

    /**
     * Load checksum from file and compare it with computed from passed data
     *
     * @param data byte array of data to process
     * @return the same byte array as passed if sum checked successfully, otherwise returns null
     */
    @Override
    public byte[] processData(byte[] data) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose filename to load checksum");
        File file = fileChooser.showOpenDialog(Stage.getWindows().filtered(Window::isShowing).get(0));
        if (file != null) {
            try (BufferedReader reader= new BufferedReader(new FileReader(file))) {
                String checksumFromFile = reader.readLine();
                String checksumReal = checksum.getChecksum(data);
                if (checksumFromFile == null || checksumReal == null || !checksumFromFile.equals(checksumReal)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Checksum check failed");
                    alert.setContentText("Checksums are not equal. Do you want to continue reading");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK){
                        return data;
                    } else {
                        return null;
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Checksum checked");
                    alert.setHeaderText(null);
                    alert.setContentText("Checksums are equal");
                    alert.showAndWait();
                    return data;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
