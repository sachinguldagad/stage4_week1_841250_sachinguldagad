package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.entity.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.service.CountryService;

@RestController
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	
	@RequestMapping(value = "/country")
	public Country getCountryIndia()
	{
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> listOfCountries = context.getBean("countryList", ArrayList.class);
		
		for(Country country: listOfCountries)
		{
			
			if(country.getCode().equals("IN"))
			{
				LOGGER.debug(country.toString());
				return country;
			}
		}
		LOGGER.info("END");
		return null;
		
	}
	
	@GetMapping("/countries")
	public ArrayList<Country> getAllCountries()
	{
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		
		ArrayList<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries = context.getBean("countryList", ArrayList.class);
		
		LOGGER.info("END");
		return listOfCountries; 
	}

	@GetMapping("/country/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException
	{
		LOGGER.info("START");
		CountryService countryService = new CountryService();
		
		Country country = countryService.getCountry(code); 
		
		LOGGER.debug(country.toString());
		
		LOGGER.info("END");
		return country; 
	}
	
	//Post Method to add the Country 
	
	@PostMapping("/countries")
	public Country addCountry(@RequestBody Country country)
	{
		LOGGER.info("START");
		
		LOGGER.debug(country.toString());
		
		LOGGER.info("END");
		return country;
	}
}
