package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController()
@RequestMapping("/countries")
@Slf4j
public class CountryController {

	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "country")
	public Country getCountryIndia() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country india = context.getBean("in", Country.class);
		return india;
	}

	@GetMapping()
	public List<Country> getAllCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>) context.getBean("countryList");
		return countries;
	}

	@GetMapping("/{code}")
	public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
		return countryService.getCountry(code);
	}

	@PostMapping()
	public Country addCountry(@RequestBody @Valid Country country) {
		log.debug("START");
		log.debug("Posted Country details: {}", country);
		return country;
	}
}
