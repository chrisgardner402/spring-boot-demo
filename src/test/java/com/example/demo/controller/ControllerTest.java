package com.example.demo.controller;

import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ControllerTest {

    @Test
    public void testHealthCheck() {
        RestAssured.given()
                .when().get("http://localhost:8080/health")
                .then().statusCode(200).log().all();
    }
}
