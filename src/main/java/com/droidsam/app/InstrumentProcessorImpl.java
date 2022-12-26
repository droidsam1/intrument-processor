package com.droidsam.app;

public class InstrumentProcessorImpl implements InstrumentProcessor {

    private final TaskDispatcher taskDispatcher;
    private final Instrument instrument;

    public InstrumentProcessorImpl(TaskDispatcher taskDispatcher, Instrument instrument) {
        this.taskDispatcher = taskDispatcher;
        this.instrument = instrument;
    }

    @Override
    public void process() {

    }
}
