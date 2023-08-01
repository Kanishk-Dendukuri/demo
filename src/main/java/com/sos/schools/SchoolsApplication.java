package com.sos.schools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SchoolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolsApplication.class, args);
	}
}
