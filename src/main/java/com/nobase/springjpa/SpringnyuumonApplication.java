package com.nobase.springjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringnyuumonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringnyuumonApplication.class, args);
	}

}
