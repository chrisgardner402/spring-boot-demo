package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import javax.sql.DataSource;
import java.util.Properties;

@Slf4j
@Configuration
public class SpringQuartzScheduler {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        log.debug("Configuring SpringBeanJobFactory");
        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(this.applicationContext);
        return jobFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource) {
        log.debug("Setting SchedulerFactoryBean");
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setDataSource(dataSource);
        schedulerFactory.setOverwriteExistingJobs(true);
        schedulerFactory.setJobFactory(this.springBeanJobFactory());
        schedulerFactory.setQuartzProperties(this.quartzProperties());
        return schedulerFactory;
    }

    private Properties quartzProperties() {
        Properties props = new Properties();
        props.put("org.quartz.scheduler.instanceName", "TestScheduler");
        props.put("org.quartz.scheduler.instanceId", "AUTO");
        props.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
        props.put("org.quartz.jobStore.useProperties", "true");
        props.put("org.quartz.jobStore.misfireThreshold", "60000");
        props.put("org.quartz.jobStore.isClustered", "true");
        return props;
    }
}
