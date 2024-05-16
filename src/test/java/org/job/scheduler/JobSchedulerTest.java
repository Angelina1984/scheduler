package org.job.scheduler;

import org.job.jobscheduler.model.EmailJob;
import org.job.jobscheduler.model.Job;
import org.job.jobscheduler.model.TimeBasedTrigger;
import org.job.jobscheduler.model.Trigger;
import org.job.jobscheduler.scheduler.JobScheduler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobSchedulerTest {
    JobScheduler jobScheduler;
    @BeforeEach
    void setUp() {
        jobScheduler = new JobScheduler();
    }

    @Test
    public void testJobSchedulerEmailJob() {
        Job job = new EmailJob("New Email 1");
        Job job2 = new EmailJob("New Email 2");
        LocalDateTime timeToTrigger = LocalDateTime.now();
        Trigger trigger = new TimeBasedTrigger(timeToTrigger);

        jobScheduler.addJob(job, trigger);
        jobScheduler.addJob(job2, trigger);
        HashMap result = jobScheduler.runJobs();
        assertEquals(result.size(), 2);
        assertEquals(result.get(0), "New Email 1");
        assertEquals(result.get(1), "New Email 2");
    }
}