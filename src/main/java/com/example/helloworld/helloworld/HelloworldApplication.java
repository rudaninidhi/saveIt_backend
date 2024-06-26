package com.example.helloworld.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class HelloworldApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
		System.out.println("Completed!");
	}
}
