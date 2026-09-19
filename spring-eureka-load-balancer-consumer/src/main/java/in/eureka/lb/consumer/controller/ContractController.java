package in.eureka.lb.consumer.controller;

import in.eureka.lb.consumer.component.QuoteRestConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/contract")
public class ContractController {

    private QuoteRestConsumer consumer;

    private ContractController(QuoteRestConsumer con){
        this.consumer = con;
    }

    @GetMapping("/get")
    public String getQuote() {
        return "FROM LOAD BALANCER CONTRACT SERVICE -- " + consumer.getQuoteConsumer();
    }
}
