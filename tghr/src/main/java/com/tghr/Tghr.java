package com.tghr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author white
 *
 */
@SpringBootApplication
public class Tghr {

	private static final Logger LOGGER = LoggerFactory.getLogger(Tghr.class);

	public static void main(String[] args) {
		SpringApplication.run(Tghr.class, args);
		LOGGER.info("Tghr application started successfully.");
	}
}
