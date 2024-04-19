package com.footbalWebScraper.footbalWebScraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FootballWebScraperApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballWebScraperApplication.class, args);
	}

}
