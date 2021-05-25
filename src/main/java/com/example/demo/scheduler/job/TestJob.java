package com.example.demo.scheduler.job;

import com.example.demo.service.TestJobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestJob extends QuartzJobBean {

    @Autowired
    private TestJobService testJobService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Job ** {} ** fired @ {}", jobExecutionContext.getJobDetail().getKey().getName(), jobExecutionContext.getFireTime());
        this.testJobService.executeTestJob();
        log.info("Next job scheduled @ {}", jobExecutionContext.getNextFireTime());
    }
}
