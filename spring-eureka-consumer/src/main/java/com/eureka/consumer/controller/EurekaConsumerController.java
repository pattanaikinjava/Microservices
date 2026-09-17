package com.eureka.consumer.controller;

import com.eureka.consumer.restconsumer.DiscoveryClientRestConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaConsumerController {

    @Autowired
    private DiscoveryClientRestConsumer discoveryClientRestConsumer;

    @GetMapping("/verify")
    public String hey() {
        return  "FROM CONSUMER -- Eureka Consumer is connected with Eureka Producer" +
                "\n" +
                "Eureka Producer is up and running!";
    }

    @GetMapping("/consume")
    public String consume() {
        return "Registered Services: " + discoveryClientRestConsumer.getServices();
    }

}
