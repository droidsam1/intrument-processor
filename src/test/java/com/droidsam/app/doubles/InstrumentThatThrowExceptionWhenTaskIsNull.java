package com.droidsam.app.doubles;

import com.droidsam.app.Instrument;

public class InstrumentThatThrowExceptionWhenTaskIsNull implements Instrument {
    @Override
    public void execute(String task, Runnable eventHandlerFinished, Runnable eventHandlerError) {
        if (task == null) {
            throw new IllegalArgumentException();
        }
    }
}
