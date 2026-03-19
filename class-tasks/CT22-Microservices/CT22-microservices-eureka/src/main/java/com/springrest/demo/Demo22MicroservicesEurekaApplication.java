package com.springrest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Demo22MicroservicesEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo22MicroservicesEurekaApplication.class, args);
	}

}
