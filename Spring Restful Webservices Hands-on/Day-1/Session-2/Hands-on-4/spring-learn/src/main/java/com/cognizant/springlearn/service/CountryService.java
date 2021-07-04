package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;

@Service
public class CountryService {

	public Country getCountry(String code) {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>) context.getBean("countryList");
		return countries.stream()
				.filter(country -> country.getCode().equalsIgnoreCase(code))
				.findFirst()
				.orElse(null);
	}

}
