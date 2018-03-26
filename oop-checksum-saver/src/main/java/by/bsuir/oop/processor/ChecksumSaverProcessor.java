package by.bsuir.oop.processor;

import by.bsuir.oop.gui.module.Processor;
import by.bsuir.oop.util.Checksum;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ChecksumSaverProcessor implements Processor {

    private Checksum checksum;

    public ChecksumSaverProcessor() {
        this.checksum = new Checksum();
    }

    /**
     * Saves checksum of data to file
     *
     * @param data byte array of data to process
     * @return the same data array
     */
    @Override
    public byte[] processData(byte[] data) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose filename to save checksum");
        File file = fileChooser.showSaveDialog(Stage.getWindows().filtered(Window::isShowing).get(0));
        if (file != null) {
            String checksumString = checksum.getChecksum(data);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(checksumString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
