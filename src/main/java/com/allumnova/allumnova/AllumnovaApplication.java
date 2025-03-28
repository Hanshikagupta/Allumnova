package com.allumnova.allumnova;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AllumnovaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllumnovaApplication.class, args);
	}
public CommandLineRunner commandLineRunner(String[] args){
		return runner->{
			System.out.println("Hello");
		};
}
}
