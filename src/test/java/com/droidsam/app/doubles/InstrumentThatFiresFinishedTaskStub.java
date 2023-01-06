package com.droidsam.app.doubles;

import com.droidsam.app.Instrument;

public class InstrumentThatFiresFinishedTaskStub implements Instrument {
    @Override
    public void execute(String task, Runnable eventHandlerFinished, Runnable eventHandlerError) {
        eventHandlerFinished.run();
    }
}
