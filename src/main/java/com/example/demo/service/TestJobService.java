package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestJobService {

    public void executeTestJob() {
        log.info("execute test job");
    }
}
