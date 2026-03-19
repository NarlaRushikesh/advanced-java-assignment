package com.productservice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoProductserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProductserviceApplication.class, args);
	}

}
