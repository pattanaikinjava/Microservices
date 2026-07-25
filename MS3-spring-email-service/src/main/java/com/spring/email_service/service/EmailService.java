package com.spring.email_service.service;

import com.spring.email_service.dto.EmailRequest;


public interface EmailService {
	void sendEmail(EmailRequest request);
}