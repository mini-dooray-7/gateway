package com.nhnacademy.mini.dooray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DoorayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoorayApplication.class, args);
	}

}
