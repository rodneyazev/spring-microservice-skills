package com.main.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
	
	@Bean
	SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeExchange(
					exchange -> exchange
						.pathMatchers("/eureka/**").permitAll()
						.pathMatchers("/actuator/**").permitAll()
						.anyExchange().authenticated())
			.oauth2ResourceServer(
					oauth2 -> oauth2
						.jwt(Customizer.withDefaults()));
		return http.build();
			
	}

}
