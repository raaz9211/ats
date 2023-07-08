package com.ai.ats;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ai.ats.repository")
public class AtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtsApplication.class, args);
	}

}
