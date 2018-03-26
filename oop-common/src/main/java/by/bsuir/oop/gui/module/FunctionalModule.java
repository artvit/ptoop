package by.bsuir.oop.gui.module;

/**
 * Interface describes functional module that must return processor.
 * Module can be used as plugin to process data on save or on reading from file.
 */
public interface FunctionalModule {
    /**
     * Creates and returns instance of corresponding processor
     *
     * @return instance of Processor
     */
    Processor getProcessor();
}
