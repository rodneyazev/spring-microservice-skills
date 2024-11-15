package com.main.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringMicroserviceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceOrderApplication.class, args);
	}

}
