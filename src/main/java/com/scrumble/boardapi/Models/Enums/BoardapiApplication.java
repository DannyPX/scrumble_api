package com.scrumble.boardapi.Models.Enums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("Models")
@SpringBootApplication

public class BoardapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardapiApplication.class, args);
	}

}
