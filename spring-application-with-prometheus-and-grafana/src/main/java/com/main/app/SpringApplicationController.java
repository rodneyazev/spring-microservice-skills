package com.main.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringApplicationController {
	
	final static Logger logger = LoggerFactory.getLogger(SpringApplicationWithPrometheusAndGrafanaApplication.class);
	
	@GetMapping("/")
	public ResponseEntity<String> createLogs(){
		logger.warn("Log check");
		return ResponseEntity.ok().body("All OK");
	}

}
