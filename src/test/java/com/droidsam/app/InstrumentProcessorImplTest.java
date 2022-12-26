package com.droidsam.app;

import com.droidsam.app.doubles.InstrumentDummy;
import com.droidsam.app.doubles.InstrumentSpy;
import com.droidsam.app.doubles.TaskDispatcherDummy;
import com.droidsam.app.doubles.TaskDispatcherSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InstrumentProcessorImplTest {


    @Test
    public void shouldReceiveTaskDispatcherAsDependency() {
        var instrumentProcessor = new InstrumentProcessorImpl(new TaskDispatcherDummy(), new InstrumentDummy());

        instrumentProcessor.process();

        assertNotNull(instrumentProcessor);
    }

    @Test
    public void shouldCallFinishedTaskAfterSuccessfullyTaskCompletion() {
        var taskDispatcher = new TaskDispatcherSpy();
        var instrumentProcessor = new InstrumentProcessorImpl(taskDispatcher, new InstrumentDummy());

        instrumentProcessor.process();

        assertEquals(1, taskDispatcher.getGetTaskInvocations());
        assertEquals(1, taskDispatcher.getFinishedTaskInvocations());
    }

    @Test
    public void shouldStartTheInstrument() {
        var taskDispatcher = new TaskDispatcherSpy();
        var instrument = new InstrumentSpy();
        var instrumentProcessor = new InstrumentProcessorImpl(taskDispatcher, instrument);

        instrumentProcessor.process();

        assertEquals(1, instrument.getExecuteInvocations());
    }
}