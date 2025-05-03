package com.eureka.balancer.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.balancer.order.consumer.OrderConsumer;


@RestController
@RequestMapping(value="/order")
public class OrderController {
	
	@Autowired
	private OrderConsumer consumer;
	
	@GetMapping(value="/get")
	public ResponseEntity<String> getMessage(){
		return ResponseEntity.ok(""+consumer.getCartResp());
	}

}
