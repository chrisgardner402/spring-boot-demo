package com.example.demo.scheduler.trigger;

import org.quartz.*;

public class TestJobTrigger {

    private static final String triggerKey = "Test_Job_Trigger";
    private static final String cronExpression = "0 0/1 * ? * * *";

    public static Trigger get(JobDetail jobDetail) {
        return TriggerBuilder.newTrigger().forJob(jobDetail)
                .withIdentity(TriggerKey.triggerKey(triggerKey))
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();
    }
}
