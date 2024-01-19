package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Ex09AssociativeMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex09AssociativeMappingApplication.class, args);
	}

}
