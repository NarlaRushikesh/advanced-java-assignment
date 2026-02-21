package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("emailBean") // Custom bean name
public class EmailNotification implements Notification {

    public EmailNotification() {
        System.out.println("EmailNotification Bean Created");
    }

    @PostConstruct
    public void init() {
        System.out.println("EmailNotification Bean Initialized");
    }

    @Override
    public void send(String message) {
        System.out.println("Email Notification sent: " + message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("EmailNotification Bean Destroyed");
    }
}