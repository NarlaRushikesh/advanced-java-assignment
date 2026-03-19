package com.springrest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Demo19SpringrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo19SpringrestApplication.class, args);
	}

}
