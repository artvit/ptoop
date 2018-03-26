package by.bsuir.oop.processor;

import by.bsuir.oop.gui.module.Processor;
import by.bsuir.oop.util.Checksum;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.util.Optional;

public class ChecksumCheckerProcessor implements Processor {

    private Checksum checksum;

    public ChecksumCheckerProcessor() {
        this.checksum = new Checksum();
    }

    @Override
    public byte[] processData(byte[] data) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose filename to save checksum");
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
                    alert.showAndWait();
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
