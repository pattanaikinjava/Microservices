package com.eureka.load.balancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringEurekaLoadBalancerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaLoadBalancerApplication.class, args);
	}

}
