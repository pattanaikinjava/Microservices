package com.eureka.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController {
/*
    Once eureka server is connected with eureka producer,
    in eureka server dashboard, you can see the eureka producer service registered with the name "spring-eureka-producer".
    Click on service name <system-host>:<service-id>:<port>
    In browser, change into http://<system-host>:<port>/pay
 */
    @GetMapping("/pay")
    public String doPay() {
        return "FROM PAYMENT -- Payment initiated successfully!";
    }

    @GetMapping("/verify")
    public String doVerify() {
        return "Eureka Client is connected with Eureka Producer" +
                "\n" +
                "Eureka Producer is up and running!";
    }
}

