package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger log = Logger.getLogger(SpringLearnApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
        log.log(Level.INFO, "Inside main");
        displayDate();
	}
	
	private static void displayDate() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			System.out.println(date);
		} catch (ParseException e) {
			System.err.println("Unable to parse date: " + e.getLocalizedMessage());
		}
				
	}

}
