package com.example.demo.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

@Slf4j
@Configuration
public class TestJobScheduler {

    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    public void start() throws SchedulerException {
        JobDetail jobDetail = jobDetail(TestJob.class);
        scheduler.scheduleJob(jobDetail, trigger(jobDetail, "0 * * * * ?"));
    }

    private JobDetail jobDetail(Class job) {
        return JobBuilder.newJob().ofType(job)
                .storeDurably()
                .withIdentity(JobKey.jobKey("Qrtz_Job_Detail"))
                .build();
    }

    private Trigger trigger(JobDetail job, String cronExpression) {
        return TriggerBuilder.newTrigger().forJob(job)
                .withIdentity(TriggerKey.triggerKey("Qrtz_Trigger"))
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();
    }
}
