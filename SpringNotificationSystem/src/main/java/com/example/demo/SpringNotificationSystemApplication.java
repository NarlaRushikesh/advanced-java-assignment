package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringNotificationSystemApplication implements CommandLineRunner {

    @Autowired
    private Notification emailBean;   // eager bean

    @Autowired
    private Notification smsBean;     // lazy bean

    public static void main(String[] args) {
        System.out.println("Starting Spring Boot Application...");
        SpringApplication.run(SpringNotificationSystemApplication.class, args);
        System.out.println("Spring Boot Application Started");
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\nInside CommandLineRunner...\n");

        // Email bean is already created (eager)
        emailBean.send("Welcome to Spring Boot Notifications!");

        System.out.println();

        // SMS bean is created here (lazy)
        smsBean.send("Your OTP is 123456");
    }
}