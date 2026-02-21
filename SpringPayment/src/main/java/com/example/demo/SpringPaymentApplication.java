package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPaymentApplication.class, args);
//		ApplicationContext context = SpringApplication.run(DemoSpringCoreApplication.class, args);
		ApplicationContext context = SpringApplication.run(Payment.class, args);
	}

}