package com.droidsam.app;

public interface Instrument {

    //Java adaptation (see https://github.com/eggstrema/instrument-processor)
    void execute(String task, Runnable eventHandlerFinished, Runnable eventHandlerError);
}
