package com.eureka.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value="/service")
@RestController
public class CartController {

	@Value("${server.port}")
	private String portNo;
	
	@GetMapping(value="/get")
	public ResponseEntity<String> getMessage() {
		return ResponseEntity.ok(
				"Welcome to Load Balancer Cart Service running at port numeber: "+portNo);
	}
	
}
