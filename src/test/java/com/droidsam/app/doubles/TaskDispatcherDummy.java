package com.droidsam.app.doubles;

import com.droidsam.app.TaskDispatcher;

public class TaskDispatcherDummy implements TaskDispatcher {
    @Override
    public String getTask() {
        return null;
    }

    @Override
    public void finishedTask(String task) {

    }
}
