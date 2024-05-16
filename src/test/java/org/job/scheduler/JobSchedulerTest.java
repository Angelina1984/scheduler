package org.job.scheduler;

import org.job.jobscheduler.model.EmailJob;
import org.job.jobscheduler.model.Job;
import org.job.jobscheduler.model.TimeBasedTrigger;
import org.job.jobscheduler.model.Trigger;
import org.job.jobscheduler.scheduler.ExecutionContext;
import org.job.jobscheduler.scheduler.JobScheduler;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobSchedulerTest {
    JobScheduler jobScheduler;

    @Test
    public void testJobSchedulerEmailJob() {
        jobScheduler = new JobScheduler(new ExecutionContext(2));
        Job job = new EmailJob("New Email 1");
        Job job2 = new EmailJob("New Email 2");
        LocalDateTime timeToTrigger = LocalDateTime.now().plusMinutes(2);
        Trigger trigger = new TimeBasedTrigger(timeToTrigger);

        jobScheduler.addJob(job, trigger);
        jobScheduler.addJob(job2, trigger);
        HashMap result = jobScheduler.runJobs();
        assertEquals(result.size(), 2);
        assertEquals(result.get(0), "New Email 1");
        assertEquals(result.get(1), "New Email 2");
    }

    @Test
    public void testJobSchedulerEmailJobConcurrencyLimitReached() {
        jobScheduler = new JobScheduler(new ExecutionContext(1));
        Job job = new EmailJob("New Email");
        Job job2 = new EmailJob("Some Email 2");
        LocalDateTime timeToTrigger = LocalDateTime.now().plusMinutes(3);
        Trigger trigger = new TimeBasedTrigger(timeToTrigger);

        jobScheduler.addJob(job, trigger);
        jobScheduler.addJob(job2, trigger);
        HashMap result = jobScheduler.runJobs();
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), "New Email");
    }
}