package com.example.demo.scheduler;

import com.example.demo.service.TestJobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestJob implements Job {

    @Autowired
    private TestJobService testJobService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("Job ** {} ** fired @ {}", jobExecutionContext.getJobDetail().getKey().getName(), jobExecutionContext.getFireTime());

        testJobService.executeTestJob();

        log.info("Next job scheduled @ {}", jobExecutionContext.getNextFireTime());
    }
}
