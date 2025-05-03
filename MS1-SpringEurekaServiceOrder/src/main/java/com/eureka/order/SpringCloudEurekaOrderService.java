package com.eureka.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudEurekaOrderService {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaOrderService.class, args);
	}

}
