package by.bsuir.oop.processor;

import by.bsuir.oop.gui.module.Processor;
import by.bsuir.ptoop.controller.module.DearchivingModule;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UnpackerAdapterProcessor implements Processor {
    private static final String TEMP_FILE_NAME = "temp-file";

    private DearchivingModule dearchivingModule;

    public UnpackerAdapterProcessor() {
        dearchivingModule = new DearchivingModule();
    }

    @Override
    public byte[] processData(byte[] data) {
        try {
            try (FileOutputStream fileOutputStream = new FileOutputStream(TEMP_FILE_NAME)) {
                fileOutputStream.write(data);
            }
            byte[] result = (byte[]) dearchivingModule.dearchiveObject(TEMP_FILE_NAME);
            Files.delete(Paths.get(TEMP_FILE_NAME));
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
