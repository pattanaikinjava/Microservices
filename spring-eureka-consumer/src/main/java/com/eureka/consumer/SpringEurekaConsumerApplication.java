package com.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//From spring-boot 4.1.1 version, No required to add @EnableEurekaClient
@SpringBootApplication
public class SpringEurekaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaConsumerApplication.class, args);
	}

}
