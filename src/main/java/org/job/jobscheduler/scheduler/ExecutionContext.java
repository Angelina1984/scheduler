package org.job.jobscheduler.scheduler;

/**
 * manages the concurrency level of job execution
 */
public class ExecutionContext {
    private int concurrencyLevel;

    public ExecutionContext(int concurrencyLevel) {
        this.concurrencyLevel = concurrencyLevel;
    }
    public int getConcurrencyLevel() {
        return concurrencyLevel;
    }

    public void setConcurrencyLevel(int concurrencyLevel) {
        this.concurrencyLevel = concurrencyLevel;
    }
}
