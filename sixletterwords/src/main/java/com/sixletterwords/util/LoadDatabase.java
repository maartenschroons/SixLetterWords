package com.sixletterwords.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sixletterwords.model.Word;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(WordRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Word("burglar")));
			log.info("Preloading " + repository.save(new Word("thief")));
		};
	}
}
