package com.connect4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


/**
 * This class is Springboot application.
 * 
 * @author harikrushna
 *
 */
@SpringBootApplication
@PropertySource({"classpath:application.properties"})
public class Connect4Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Connect4Application.class, args);
	}
	
}
