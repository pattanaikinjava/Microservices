package com.eureka.order.consumer;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartConsumer {
	
	@Autowired
	private DiscoveryClient client;
	
	public String getCartResponse() {
		List<ServiceInstance> siList 
		      = client.getInstances("EUREKA-SERVICE.COM");
		ServiceInstance si = siList.get(0);
		URI url = si.getUri();
		String finalPath = url + "/cart/service/msg";
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> responseEntity =
				template.getForEntity(finalPath, String.class);
		return responseEntity.getBody();
	}

}
