package com.eureka.consumer.restconsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DiscoveryClientRestConsumer {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${eureka.producer.serviceId}")
    private String EUREKA_SERVICE_ID;

    @Value("${eureka.producer.path}")
    private String EUREKA_SERVICE_PATH;


    public String getServices(){
        //get all registered services
        discoveryClient.getServices().forEach(
                System.out::println
        );

        //get instances based on ServiceId (SID)
        List<ServiceInstance> list = discoveryClient.getInstances(EUREKA_SERVICE_ID);
        ServiceInstance instance = list.get(0);
        System.out.println("instance details: "+ instance);
        //create URI and add /path
        String url = instance.getUri() + "/" + EUREKA_SERVICE_PATH;
        //create ReST Template object and make HTTP call request
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity(url, String.class);
        return response.getBody();
    }
}
