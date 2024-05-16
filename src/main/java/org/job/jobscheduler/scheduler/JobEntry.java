package org.job.jobscheduler.scheduler;

import org.job.jobscheduler.model.Job;
import org.job.jobscheduler.model.Trigger;

public class JobEntry {
    private final Job job;
    private final Trigger trigger;

    public JobEntry(Job job, Trigger trigger) {
        this.job = job;
        this.trigger = trigger;
    }

    public Job getJob() {
        return this.job;
    }

    public Trigger getTrigger() {
        return this.trigger;
    }
}
