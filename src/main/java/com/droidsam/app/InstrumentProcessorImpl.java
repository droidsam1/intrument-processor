package com.droidsam.app;


import java.io.PrintStream;

public class InstrumentProcessorImpl implements InstrumentProcessor {

    private final TaskDispatcher taskDispatcher;
    private final Instrument instrument;
    private final PrintStream console;

    public InstrumentProcessorImpl(TaskDispatcher taskDispatcher, Instrument instrument) {
        this.taskDispatcher = taskDispatcher;
        this.instrument = instrument;
        this.console = System.out;
    }

    public InstrumentProcessorImpl(TaskDispatcher taskDispatcher, Instrument instrument, PrintStream console) {
        this.taskDispatcher = taskDispatcher;
        this.instrument = instrument;
        this.console = console;
    }

    @Override
    public void process() {
        var task = this.taskDispatcher.getTask();
        instrument.execute(task, () -> taskDispatcher.finishedTask(task), () -> console.println("Error occurred"));
    }
}
