package com.droidsam.app;

import com.droidsam.app.doubles.InstrumentDummy;
import com.droidsam.app.doubles.TaskDispatcherDummy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class InstrumentProcessorImplTest {


    @Test
    public void shouldReceiveTaskDispatcherAsDependency() {
        var instrumentProcessor = new InstrumentProcessorImpl(new TaskDispatcherDummy(), new InstrumentDummy());

        instrumentProcessor.process();

        assertNotNull(instrumentProcessor);
    }
}