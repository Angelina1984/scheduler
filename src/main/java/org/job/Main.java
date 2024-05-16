package org.job;

import org.job.jobscheduler.model.EmailJob;
import org.job.jobscheduler.model.Job;
import org.job.jobscheduler.model.TimeBasedTrigger;
import org.job.jobscheduler.model.Trigger;
import org.job.jobscheduler.scheduler.JobScheduler;

import java.time.LocalDateTime;

public class Main {
    /**
     * This example demonstrates how to use job scheduler by creating an email job and a
     * time-based trigger, adding them to the scheduler, and running the scheduler.
     * @param args
     */
    public static void main(String[] args) {
        Job job = new EmailJob("New Email 1");
        Job job2 = new EmailJob("New Email 2");
        LocalDateTime timeToTrigger = LocalDateTime.now();
        Trigger trigger = new TimeBasedTrigger(timeToTrigger);

        JobScheduler jobScheduler = new JobScheduler();
        jobScheduler.addJob(job, trigger);
        jobScheduler.addJob(job2, trigger);
        jobScheduler.runJobs();
    }
}