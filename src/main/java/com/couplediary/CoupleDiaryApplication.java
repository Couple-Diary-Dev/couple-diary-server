package com.couplediary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CoupleDiaryApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoupleDiaryApplication.class, args);
	}
}

@RestController
@RequestMapping("/health-check")
class HealthCheckController {
	@GetMapping
	public ResponseEntity<String> healthCheck() {
		return ResponseEntity.ok().body("ok");
	}
}
