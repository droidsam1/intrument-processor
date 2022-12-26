package com.droidsam.app.doubles;

import com.droidsam.app.Instrument;

public class InstrumentSpy implements Instrument {

    private int executeInvocations = 0;

    @Override
    public void execute(String task, Runnable eventHandlerFinished, Runnable eventHandlerError) {
        executeInvocations++;
    }

    private int getExecuteInvocations() {
        return executeInvocations;
    }

    public boolean isExecuteCalled() {
        return getExecuteInvocations() != 0;
    }
}
