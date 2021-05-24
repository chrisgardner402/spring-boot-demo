package com.example.demo.scheduler;

import com.example.demo.scheduler.jobdetail.TestJobDetail;
import com.example.demo.scheduler.trigger.TestJobTrigger;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class TestJobScheduler {

    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    public void start() throws SchedulerException {
        JobDetail testJobDetail = TestJobDetail.get();
        Trigger testTrigger = TestJobTrigger.get(testJobDetail);
        scheduler.scheduleJob(testJobDetail, testTrigger);
    }
}
