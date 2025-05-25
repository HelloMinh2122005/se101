package com.se101.publicservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient 
@RequestMapping("/public")
public class PublicserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicserviceApplication.class, args);
	}

	@GetMapping("/")
	public String publicEndpoint() {
		return "This is a public endpoint accessible without authentication.";
	}

}
