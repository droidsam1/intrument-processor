package com.droidsam.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class InstrumentProcessorImplTest {


    @Test
    public void canBeInstantiated() {
        InstrumentProcessor instrumentProcessor = new InstrumentProcessorImpl();
        instrumentProcessor.process();

        assertNotNull(instrumentProcessor);
    }
}