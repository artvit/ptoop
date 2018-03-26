package by.bsuir.oop.processor;

import by.bsuir.oop.gui.module.Processor;
import by.bsuir.ptoop.controller.util.DearchivingUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UnpackerAdapterProcessor implements Processor {
    private static final String TEMP_FILE_NAME = "temp-file";

    public UnpackerAdapterProcessor() {
    }

    @Override
    public byte[] processData(byte[] data) {
        try {
            try (FileOutputStream fileOutputStream = new FileOutputStream(TEMP_FILE_NAME + ".gz")) {
                fileOutputStream.write(data);
            }
            byte[] result = (byte[]) DearchivingUtil.dearchiveObject(TEMP_FILE_NAME);
            Files.delete(Paths.get(TEMP_FILE_NAME + ".gz"));
            return result;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
