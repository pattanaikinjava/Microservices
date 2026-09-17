package com.job.cron_schedular.config;

import com.job.cron_schedular.jobs.EmailJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class QuartzConfiguration {

    @Bean
    public JobDetail emailJobDetail() {

        return JobBuilder.newJob(EmailJob.class)
                .withIdentity("emailJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger emailTrigger(JobDetail emailJobDetail) {
        System.out.println("job schedular started....");
        Date startTime = new Date(System.currentTimeMillis() + 1 * 60 * 1000);
        return TriggerBuilder.newTrigger()
                .forJob(emailJobDetail)
                .withIdentity("emailTrigger")
                .startAt(startTime)
//                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(30)
                                .repeatForever()
                )
                .build();
    }

}