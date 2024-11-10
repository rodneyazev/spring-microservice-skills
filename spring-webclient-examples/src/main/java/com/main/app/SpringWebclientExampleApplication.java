package com.main.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SpringWebclientExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebclientExampleApplication.class, args);
		
		String url = "https://catfact.ninja/fact?max_length=140";
		WebClient.Builder builder = WebClient.builder();
		
		String catFact = builder.build().get().uri(url).retrieve().bodyToMono(String.class).block();
		
		System.out.println("-------------------------------");
		System.out.println(catFact);
		System.out.println("-------------------------------");
		
		CatFact catFactUsingClass = builder.build().get().uri(url).retrieve().bodyToMono(CatFact.class).block();
		
		System.out.println("-------------------------------");
		System.out.println(catFactUsingClass);
		System.out.println("-------------------------------");
				
	}

}
