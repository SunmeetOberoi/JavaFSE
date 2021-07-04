package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Inside main");
		displayCountries();
	}

	private static void displayDate() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			LOGGER.debug(date.toString());
		} catch (ParseException e) {
			LOGGER.error("Unable to parse date: " + e.getLocalizedMessage());
		}

		LOGGER.info("END");

	}

	private static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
	}

	private static void displayCountries() {

		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List<Country> countries = (List<Country>) context.getBean("countryList");

		LOGGER.debug("Countries : {}", countries);
		LOGGER.info("END");
	}

}
