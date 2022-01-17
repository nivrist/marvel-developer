package com.marvel.developer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;



@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })	
public class MarvelAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelAuthApplication.class, args);
	}
	
	

}
