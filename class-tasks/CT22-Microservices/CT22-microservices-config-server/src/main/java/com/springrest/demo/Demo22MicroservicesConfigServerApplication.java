package com.springrest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Demo22MicroservicesConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo22MicroservicesConfigServerApplication.class, args);
	}

}
