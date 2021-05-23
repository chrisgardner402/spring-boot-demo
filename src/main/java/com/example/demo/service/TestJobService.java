package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestJobService {

    private static final long EXECUTION_TIME = 5000L;

    public void executeTestJob() {
        log.info("The test job has begun...");
        try {
            Thread.sleep(EXECUTION_TIME);
        } catch (InterruptedException e) {
            log.error("Error while executing test job", e);
        } finally {
            log.info("test job has finished...");
        }
    }
}
