package com.droidsam.app;

import com.droidsam.app.doubles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstrumentProcessorImplTest {


    @Test
    public void shouldReceiveTaskDispatcherAsDependency() {
        var instrumentProcessor = new InstrumentProcessorImpl(new TaskDispatcherDummy(), new InstrumentDummy());

        instrumentProcessor.process();

        assertNotNull(instrumentProcessor);
    }

    @Test
    public void shouldCallFinishedTaskAfterSuccessfullyTaskCompletion() {
        var instrument = new InstrumentThatFiresFinishedTaskFake();
        var taskDispatcher = new TaskDispatcherSpy();
        var instrumentProcessor = new InstrumentProcessorImpl(taskDispatcher, instrument);

        instrumentProcessor.process();

        assertTrue(taskDispatcher.isGetTaskCalled());
        assertTrue(taskDispatcher.isFinishedTaskCalled());
    }

    @Test
    public void shouldStartTheInstrument() {
        var taskDispatcher = new TaskDispatcherSpy();
        var instrument = new InstrumentSpy();
        var instrumentProcessor = new InstrumentProcessorImpl(taskDispatcher, instrument);

        instrumentProcessor.process();

        assertTrue(instrument.isExecuteCalled());
    }

    @Test
    public void shouldThrowExceptionIfTaskPassedToInstrumentIsNull() {
        var instrument = new InstrumentThatThrowExceptionWhenTaskIsNullFake();
        var instrumentProcessor = new InstrumentProcessorImpl(new TaskDispatcherDummy(), instrument);


        assertThrows(IllegalArgumentException.class, instrumentProcessor::process);
    }

    @Test
    public void shouldCallFinishedTaskWithTheCorrectTaskWhenInstrumentFiresTheFinishedEvent() {
        var PENDING_TASK = "Task1";
        var instrument = new InstrumentThatFiresFinishedTaskFake();
        var taskDispatcher = TaskDispatcherSpy.withPendingTasks(PENDING_TASK);
        var instrumentProcessor = new InstrumentProcessorImpl(taskDispatcher, instrument);

        instrumentProcessor.process();

        assertTrue(taskDispatcher.isFinishedTaskCalled());
        assertTrue(taskDispatcher.getFinishedTaskMethodInvocationArguments().contains(PENDING_TASK));
    }

    @Test
    public void shouldInstrumentProcessorWriteErrorToConsoleWhenInstrumentDetectsAndErrorSituation() {

        var instrument = new InstrumentThatFiresErrorFake();
        var taskDispatcher = new TaskDispatcherSpy();
        var consoleSpy = new ConsoleSpy();
        var instrumentProcessor = new InstrumentProcessorImpl(taskDispatcher, instrument, consoleSpy);

        instrumentProcessor.process();

        assertFalse(taskDispatcher.isFinishedTaskCalled());
        assertEquals("Error occurred", consoleSpy.getPrintedString());
    }
}