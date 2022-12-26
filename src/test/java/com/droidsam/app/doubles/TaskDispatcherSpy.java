package com.droidsam.app.doubles;

import com.droidsam.app.TaskDispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TaskDispatcherSpy implements TaskDispatcher {

    private final List<String> finishedTasks;
    private final Stack<String> pendingTasks;
    private int getTaskInvocations;
    private int finishedTaskInvocations;

    public TaskDispatcherSpy() {
        this.pendingTasks = new Stack<>();
        finishedTasks = new ArrayList<>();
        getTaskInvocations = 0;
        finishedTaskInvocations = 0;
    }

    private TaskDispatcherSpy(List<String> pendingTasks) {
        this.pendingTasks = new Stack<>();
        this.pendingTasks.addAll(pendingTasks);
        finishedTasks = new ArrayList<>();
        getTaskInvocations = 0;
        finishedTaskInvocations = 0;
    }

    public static TaskDispatcherSpy withPendingTasks(String... pendingTasks) {
        return new TaskDispatcherSpy(List.of(pendingTasks));
    }

    public static TaskDispatcherSpy withPendingTasks(List<String> pendingTasks) {
        return new TaskDispatcherSpy(pendingTasks);
    }

    @Override
    public String getTask() {
        getTaskInvocations++;

        if (pendingTasks.isEmpty()) {
            return null;
        }

        return pendingTasks.pop();
    }

    @Override
    public void finishedTask(String task) {
        finishedTasks.add(task);
        finishedTaskInvocations++;
    }

    private int getFinishedTaskInvocations() {
        return finishedTaskInvocations;
    }

    public boolean isFinishedTaskCalled() {
        return getFinishedTaskInvocations() != 0;

    }

    public boolean isGetTaskCalled() {
        return getGetTaskInvocations() != 0;
    }

    private int getGetTaskInvocations() {
        return getTaskInvocations;
    }

    public List<String> getFinishedTaskMethodInvocationArguments() {
        return finishedTasks;
    }
}
