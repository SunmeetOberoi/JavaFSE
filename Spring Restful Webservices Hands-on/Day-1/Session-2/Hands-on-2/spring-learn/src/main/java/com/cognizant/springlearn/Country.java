package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
	private String code;
	private String name;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public Country() {
		LOGGER.debug("Inside Country Constructor");
	}

	public String getCode() {
		LOGGER.debug("Inside Code Getter");
		return code;
	}

	public void setCode(String code) {
		LOGGER.debug("Inside Code Setter");
		this.code = code;
	}

	public String getName() {
		LOGGER.debug("Inside Name Getter");
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("Inside Name Setter");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}	
}
