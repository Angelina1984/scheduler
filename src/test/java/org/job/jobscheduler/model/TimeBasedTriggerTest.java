package org.job.jobscheduler.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TimeBasedTriggerTest {
    TimeBasedTrigger timeBasedTrigger;

    @Test
    void shouldTriggerTest() {
        timeBasedTrigger = new TimeBasedTrigger(LocalDateTime.now().plusMinutes(5));
        boolean result = timeBasedTrigger.shouldTrigger();
        assertTrue(result);
    }

    @Test
    void shouldNotTriggerTest() {
        timeBasedTrigger = new TimeBasedTrigger(LocalDateTime.now().minusMinutes(5));
        boolean result = timeBasedTrigger.shouldTrigger();
        assertFalse(result);
    }
}