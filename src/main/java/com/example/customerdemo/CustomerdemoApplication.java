package com.example.customerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CustomerdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerdemoApplication.class, args);
	}
//	--spring.profiles.active=dev
}
