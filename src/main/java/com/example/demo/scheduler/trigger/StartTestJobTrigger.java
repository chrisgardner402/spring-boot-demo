package com.example.demo.scheduler.trigger;

import org.quartz.*;
import org.springframework.stereotype.Component;

@Component
public class StartTestJobTrigger {

    private static final String triggerKey = "Start_Test_Job_Trigger";

    public static Trigger get(JobDetail jobDetail) {
        return TriggerBuilder.newTrigger().forJob(jobDetail)
                .withIdentity(TriggerKey.triggerKey(triggerKey))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(0))
                .build();
    }
}
