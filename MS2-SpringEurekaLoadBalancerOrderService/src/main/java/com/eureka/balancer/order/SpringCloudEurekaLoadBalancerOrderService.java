package com.eureka.balancer.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudEurekaLoadBalancerOrderService{

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaLoadBalancerOrderService.class, args);
	}

}
