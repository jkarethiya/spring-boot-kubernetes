package com.example.springbootkubernetes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootKubernetesApplication {

	Logger logger = LoggerFactory.getLogger(SpringBootKubernetesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKubernetesApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		logger.info("Home api called");
		return "Hello Kubernetes World";
	}
}
