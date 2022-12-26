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
        var task = this.taskDispatcher.getTask();
        instrument.execute(task, () -> taskDispatcher.finishedTask(task), null);
    }
}
