package com.example.demo.scheduler.jobdetail;

import com.example.demo.scheduler.job.TestJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;

public class StartTestJobDetail {

    private static final String jobKey = "Start_Test_Job_Detail";

    public static JobDetail get() {
        return JobBuilder.newJob().ofType(TestJob.class)
                .storeDurably()
                .withIdentity(JobKey.jobKey(jobKey))
                .build();
    }
}
