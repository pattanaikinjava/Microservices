package in.eureka.lb.consumer.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;

@Component
public class QuoteRestConsumer {

    @Autowired
    private LoadBalancerClient client;

    @Value("${eureka.service.name}")
    private String EUREKA_SERVICE_NAME;

    @Value("${eureka.service.path}")
    private String EUREKA_SERVICE_PATH;

    public String getQuoteConsumer(){
      try {  //select service id having less load factor
          var si = client.choose(EUREKA_SERVICE_NAME);
          String CONSTRUCTED_URL = si.getUri() + "/" + EUREKA_SERVICE_PATH;
          RestTemplate template = null;
          try {
              template = new RestTemplate();
              ResponseEntity<String> response = template.getForEntity(CONSTRUCTED_URL, String.class);
              return response.getBody();
          } catch (Exception e) {
              if (e instanceof ConnectException) {
                  return "FROM LOAD BALANCER CONSUMER -- Eureka Producer is down or not reachable. Please check the Eureka Producer service.";
              } else {
                  System.out.println(e.getMessage());
                  return "Response Failed --> INTERNAL_SERVER_ERROR";
              }
          }
      } catch(Exception e){
          return e.toString();
      }

    }
}
