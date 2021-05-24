package com.example.demo.scheduler.jobdetail;

import com.example.demo.scheduler.job.TestJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;

public class TestJobDetail {

    private static final String jobKey = "Test_Job_Detail";

    public static JobDetail get() {
        return JobBuilder.newJob().ofType(TestJob.class)
                .storeDurably()
                .withIdentity(JobKey.jobKey(jobKey))
                .build();
    }
}
