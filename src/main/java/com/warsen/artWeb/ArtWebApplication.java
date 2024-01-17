package com.warsen.artWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class ArtWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtWebApplication.class, args);
	}

}
