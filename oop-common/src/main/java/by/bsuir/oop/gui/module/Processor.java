package by.bsuir.oop.gui.module;

/**
 * Processor is used to process data passed to it.
 */
public interface Processor {
    /**
     * Process data. If processor does only side effects it returns unchanged data.
     * Passed data might be changed by processor.
     *
     * @param data byte array of data to process
     * @return processed data as byte array
     */
    byte[] processData(byte[] data);
}
