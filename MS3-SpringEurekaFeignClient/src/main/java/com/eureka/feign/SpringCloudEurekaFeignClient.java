package com.eureka.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaFeignClient {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaFeignClient.class, args);
	}

}
