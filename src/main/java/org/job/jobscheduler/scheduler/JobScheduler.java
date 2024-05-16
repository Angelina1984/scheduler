package org.job.jobscheduler.scheduler;

import org.job.jobscheduler.model.Job;
import org.job.jobscheduler.model.Trigger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class JobScheduler {
    private static final Logger logger = Logger.getLogger(JobScheduler.class.getName());

    private ExecutionContext executionContext;

    List<JobEntry> jobs = new ArrayList<>();

    public JobScheduler( ExecutionContext executionContext) {
        this.executionContext = executionContext;
    }

    public void addJob(Job job, Trigger trigger) {
        jobs.add(new JobEntry(job, trigger));
    }

    public HashMap runJobs() {
        HashMap<Integer, String> jobsExecuted = new HashMap<>();
        int counter = 0;

        for(JobEntry job : jobs) {
            if(counter < executionContext.getConcurrencyLevel()) {
                if(job.getTrigger().shouldTrigger()){
                    String result = job.getJob().execute();
                    jobsExecuted.put(counter++, result);
                    logger.info("Job executed successfully: " + result);
                }
            } else {
                logger.warning("Concurrency limit reached. Not executing further jobs.");
                break; //Stop running jobs if concurrency limit reached
            }
        }
        return jobsExecuted;
    }
}
