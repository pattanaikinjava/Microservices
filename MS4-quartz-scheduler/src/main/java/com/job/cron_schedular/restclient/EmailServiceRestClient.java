package com.job.cron_schedular.restclient;

import com.job.cron_schedular.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class EmailServiceRestClient {

    private final RestClient restClient;

    @Value("${email.service.url}")
    private String emailServiceUri;

    public EmailServiceRestClient(RestClient.Builder builder) {
        this.restClient = builder.build();
    }

    public void sendMail() {

        EmailRequest request = new EmailRequest();

        request.setTo("pattanaikd1998@gmail.com");
        request.setSubject("Quartz Scheduler");
        request.setBody("Email triggered from Quartz Scheduler");

        restClient.post()
                .uri(emailServiceUri)
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }
}