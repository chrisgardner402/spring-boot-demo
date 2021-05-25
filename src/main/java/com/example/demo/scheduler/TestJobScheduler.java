package com.example.demo.scheduler;

import com.example.demo.scheduler.jobdetail.StartTestJobDetail;
import com.example.demo.scheduler.jobdetail.TestJobDetail;
import com.example.demo.scheduler.trigger.StartTestJobTrigger;
import com.example.demo.scheduler.trigger.TestJobTrigger;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Slf4j
@Configuration
public class TestJobScheduler {

    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    public void scheduleTestJob() throws SchedulerException {
        JobDetail testJobDetail = TestJobDetail.get();
        Trigger testTrigger = TestJobTrigger.get(testJobDetail);
        this.scheduler.scheduleJob(testJobDetail, Collections.singleton(testTrigger), true);
    }

    @PostConstruct
    public void scheduleStartTestJob() throws SchedulerException {
        JobDetail startTestJobDetail = StartTestJobDetail.get();
        Trigger startTestTrigger = StartTestJobTrigger.get(startTestJobDetail);
        this.scheduler.scheduleJob(startTestJobDetail, Collections.singleton(startTestTrigger), true);
    }
}
