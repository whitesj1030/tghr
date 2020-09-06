package com.tghr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Together main 
 * @author white
 *
 */
@EnableJpaAuditing
@SpringBootApplication
public class TghrApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TghrApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TghrApplication.class, args);
		LOGGER.info("Tghr application started successfully.");
	}
}
