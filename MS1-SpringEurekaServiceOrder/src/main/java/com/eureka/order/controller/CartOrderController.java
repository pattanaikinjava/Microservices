package com.eureka.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.order.consumer.CartConsumer;

@RestController
@RequestMapping(value="/cart/order")
public class CartOrderController {
	
	@Autowired
	private CartConsumer consumer;
	
	@GetMapping(value="/get")
	public ResponseEntity<String> getInfo(){
		return ResponseEntity.ok("Order place with :"+
					consumer.getCartResponse());
	}

}
