package com.se101.microservice.protectedservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RequestMapping("/protected")
public class ProtectedserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtectedserviceApplication.class, args);
	}

	@GetMapping("/")
	public String protectedEndpoint() {
		return "This is a protected endpoint accessible only with authentication.";
	}
}
