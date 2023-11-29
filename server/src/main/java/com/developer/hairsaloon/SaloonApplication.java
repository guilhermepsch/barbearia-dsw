package com.developer.hairsaloon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class SaloonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaloonApplication.class, args);
	}

}
