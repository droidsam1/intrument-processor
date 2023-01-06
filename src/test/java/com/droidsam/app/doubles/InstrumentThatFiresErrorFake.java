package com.droidsam.app.doubles;

import com.droidsam.app.Instrument;

public class InstrumentThatFiresErrorFake implements Instrument {
    @Override
    public void execute(String task, Runnable eventHandlerFinished, Runnable eventHandlerError) {
        eventHandlerError.run();
    }
}
