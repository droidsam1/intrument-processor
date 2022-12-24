package com.droidsam.app;

public interface TaskDispatcher {
    String getTask();

    void finishedTask(String task);
}
