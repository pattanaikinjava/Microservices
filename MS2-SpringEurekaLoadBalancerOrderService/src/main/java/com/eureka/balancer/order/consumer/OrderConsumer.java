package com.eureka.balancer.order.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderConsumer {

	@Autowired
	private LoadBalancerClient balancerClient;
	 public String getCartResp() {
		 ServiceInstance si = balancerClient.choose("EUREKA-LOAD-BALANCER-CART-SERVICE.COM");
			String url = si.getUri() + "/service/get";
			System.out.println("*********************** " + url +" **********************");
			RestTemplate rt = new RestTemplate();
			ResponseEntity<String> response = rt.getForEntity(url, String.class);
			return response.getBody();
	 }
}
