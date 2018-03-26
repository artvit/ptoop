package by.bsuir.oop.module;

import by.bsuir.oop.gui.module.FunctionalModule;
import by.bsuir.oop.gui.module.Processor;
import by.bsuir.oop.processor.ChecksumCheckerProcessor;

public class ChecksumCheckerModule implements FunctionalModule{

    @Override
    public Processor getProcessor() {
        return new ChecksumCheckerProcessor();
    }
}
