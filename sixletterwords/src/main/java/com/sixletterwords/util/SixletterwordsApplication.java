package com.sixletterwords.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.sixletterwords.*")
@ComponentScan(basePackages = { "com.sixletterwords.*" })
@EntityScan("com.sixletterwords.*")
@SpringBootApplication
public class SixletterwordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SixletterwordsApplication.class, args);
	}

}
