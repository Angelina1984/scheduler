package org.job.jobscheduler.scheduler;

import org.job.jobscheduler.model.Job;
import org.job.jobscheduler.model.Trigger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JobScheduler {

    List<JobEntry> jobs = new ArrayList<>();

    public void addJob(Job job, Trigger trigger) {
        jobs.add(new JobEntry(job, trigger));
    }

    public HashMap runJobs() {
        HashMap<Integer, String> jobsExecuted = new HashMap<>();
        int counter = 0;

        for(JobEntry job : jobs) {
            if(job.getTrigger().shouldTrigger()){
                jobsExecuted.put(counter++, job.getJob().execute());
            }
        }
        return jobsExecuted;
    }
}
