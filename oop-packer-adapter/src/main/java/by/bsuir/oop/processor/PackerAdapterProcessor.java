package by.bsuir.oop.processor;

import by.bsuir.oop.gui.module.Processor;
import by.bsuir.ptoop.controller.util.ArchivingUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PackerAdapterProcessor implements Processor {
    private static final String TEMP_FILE_NAME = "temp-file";

    public PackerAdapterProcessor() {
    }

    @Override
    public byte[] processData(byte[] data) {
        try {
            ArchivingUtility.archiveObject(TEMP_FILE_NAME, data);
            byte[] result;
            try (FileInputStream fileInputStream = new FileInputStream(TEMP_FILE_NAME + ".gz")) {
                result = fileInputStream.readAllBytes();
            }
            Files.delete(Paths.get( TEMP_FILE_NAME + ".gz"));
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
