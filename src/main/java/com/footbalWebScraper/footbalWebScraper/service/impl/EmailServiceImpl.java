package com.footbalWebScraper.footbalWebScraper.service.impl;

import com.footbalWebScraper.footbalWebScraper.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String to, String object, String content) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(object);
        message.setText(content);

        mailSender.send(message);
    }

    public void sendTestEmail() {
        sendEmail("uttu.sri@outlook.com", "Test Email", "Hello, this is a test email from my Spring Boot application.");
    }
}
