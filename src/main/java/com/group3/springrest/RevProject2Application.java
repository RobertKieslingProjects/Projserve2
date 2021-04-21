package com.group3.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.group3.springrest"})
public class RevProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(RevProject2Application.class, args);
	}

}
