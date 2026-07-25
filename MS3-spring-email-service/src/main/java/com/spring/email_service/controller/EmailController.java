package com.spring.email_service.controller;


import com.spring.email_service.dto.EmailRequest;
import com.spring.email_service.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/send")
	public ResponseEntity<String> sendEmail(
			@RequestBody EmailRequest request) {

		emailService.sendEmail(request);

		return ResponseEntity.ok("Email sent successfully.");
	}

}