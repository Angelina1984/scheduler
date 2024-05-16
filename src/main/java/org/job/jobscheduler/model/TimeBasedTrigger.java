package org.job.jobscheduler.model;

import java.time.LocalDateTime;

public class TimeBasedTrigger implements Trigger {
    final LocalDateTime timeToTrigger;

    public TimeBasedTrigger(LocalDateTime timeToTrigger) {
        this.timeToTrigger = timeToTrigger;
    }

    public boolean shouldTrigger() {
        return LocalDateTime.now().isAfter(timeToTrigger);
    }
}
