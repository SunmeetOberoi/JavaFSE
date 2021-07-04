package com.cognizant.springlearn;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger log = Logger.getLogger(SpringLearnApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
        log.log(Level.INFO, "Inside main");

	}
	

}
