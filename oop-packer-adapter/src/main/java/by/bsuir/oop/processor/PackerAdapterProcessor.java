package by.bsuir.oop.processor;

import by.bsuir.oop.gui.module.Processor;
import by.bsuir.ptoop.controller.module.ArchivingModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PackerAdapterProcessor implements Processor {
    private static final String TEMP_FILE_NAME = "temp-file";

    private ArchivingModule archivingModule;

    public PackerAdapterProcessor() {
        archivingModule = new ArchivingModule();
    }

    @Override
    public byte[] processData(byte[] data) {
        try {
            archivingModule.archiveObject(TEMP_FILE_NAME, data);
            byte[] result;
            try (FileInputStream fileInputStream = new FileInputStream(TEMP_FILE_NAME)) {
                result = fileInputStream.readAllBytes();
            }
            Files.delete(Paths.get(TEMP_FILE_NAME));
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
