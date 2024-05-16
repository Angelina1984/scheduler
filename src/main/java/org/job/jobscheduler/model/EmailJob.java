package org.job.jobscheduler.model;

public class EmailJob implements Job {
    private String messageToSend;
    public EmailJob(String messageToSend) {
    this.messageToSend = messageToSend;
    }

    public String execute() {
        return messageToSend;
    }
}
