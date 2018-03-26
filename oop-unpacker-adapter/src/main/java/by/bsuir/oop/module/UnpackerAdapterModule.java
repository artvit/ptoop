package by.bsuir.oop.module;

import by.bsuir.oop.gui.module.FunctionalModule;
import by.bsuir.oop.gui.module.Processor;
import by.bsuir.oop.processor.UnpackerAdapterProcessor;

public class UnpackerAdapterModule implements FunctionalModule {
    @Override
    public Processor getProcessor() {
        return new UnpackerAdapterProcessor();
    }
}
