package com.main.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringMicroserviceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceProductApplication.class, args);
	}

}
