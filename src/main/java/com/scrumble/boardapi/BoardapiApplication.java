package com.scrumble.boardapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EntityScan("com/scrumble/boardapi/Models")
@SpringBootApplication
@EnableSwagger2
public class BoardapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(BoardapiApplication.class, args);
	}
}
