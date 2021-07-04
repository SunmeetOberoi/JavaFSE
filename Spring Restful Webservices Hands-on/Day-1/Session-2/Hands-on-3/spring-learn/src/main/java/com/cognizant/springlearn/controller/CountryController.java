package com.cognizant.springlearn.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;

@RestController
public class CountryController {
	
	@RequestMapping(value="country")
	public Country getCountryIndia() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country india = context.getBean("in", Country.class);
		return india;
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries(){
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>) context.getBean("countryList");
		return countries;
	}
}
