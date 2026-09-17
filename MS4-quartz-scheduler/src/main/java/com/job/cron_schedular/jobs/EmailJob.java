package com.job.cron_schedular.jobs;

import com.job.cron_schedular.restclient.EmailServiceRestClient;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class EmailJob implements Job {

    private final EmailServiceRestClient emailClient;

    public EmailJob(EmailServiceRestClient emailClient) {
        this.emailClient = emailClient;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        System.out.println("Quartz Job Started...");

        try {
            emailClient.sendMail();
        } catch (Exception e) {
            throw new JobExecutionException("Failed to send email", e);
        }

        System.out.println("Quartz Job Finished...");
    }
}