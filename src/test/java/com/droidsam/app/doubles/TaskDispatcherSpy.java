package com.droidsam.app.doubles;

import com.droidsam.app.TaskDispatcher;

public class TaskDispatcherSpy implements TaskDispatcher {

    private int getTaskInvocations = 0;
    private int finishedTaskInvocations = 0;

    @Override
    public String getTask() {
        getTaskInvocations++;
        return null;
    }

    @Override
    public void finishedTask(String task) {
        finishedTaskInvocations++;
    }

    public int getFinishedTaskInvocations() {
        return finishedTaskInvocations;
    }

    public int getGetTaskInvocations() {
        return getTaskInvocations;
    }
}
