package in.eureka.lb.producer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/quote")
public class QuoteReSTController {

    @Value("${server.port}")
    private Integer serverPort;

    @Value("${quote.message:No quote message found}")
    private String quoteMessage;

    @GetMapping("/get")
    public String getQuote() {
    return "FROM QUOTE CONTROLLER:" +
            "\n"
            + " Quote Port: "+ serverPort +
            "\n" +
            " Quote Message: " + quoteMessage;
    }
}
