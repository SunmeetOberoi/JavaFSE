package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringLearnApplication;

@RestController
public class HelloController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	@GetMapping(value = "hello")
	public String sayHello() {
		LOGGER.debug("START");
		LOGGER.debug("END");
		return "Hello World!!";
	}
}
