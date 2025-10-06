package com.codeplay.scholamate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.codeplay.scholamate.repository")
@EntityScan("com.codeplay.scholamate.domain.entity")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@SpringBootApplication
public class ScholamateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScholamateApplication.class, args);
	}
}
