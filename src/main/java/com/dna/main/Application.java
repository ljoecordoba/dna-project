package com.dna.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication @ComponentScan({"com.dna.controller","com.dna.domain","com.dna.repository"})
@EnableMongoRepositories("com.dna.repository")
@EnableAutoConfiguration

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
