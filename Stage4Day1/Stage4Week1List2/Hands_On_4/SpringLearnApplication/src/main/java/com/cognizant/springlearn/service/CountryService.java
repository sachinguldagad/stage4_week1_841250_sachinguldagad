package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.entity.Country;

@Service
public class CountryService {

	public Country getCountry(String code)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> listOfCountries = listOfCountries = context.getBean("countryList", ArrayList.class);
		
//		
//		listOfCountries.forEach(value->
//		{ 
//			Country country;
//			if(value.getCode().equalsIgnoreCase(code)) 
//			{
//				country = value;
//			}
//		});
		
		for(Country country:listOfCountries)
		{
			if(country.getCode().equalsIgnoreCase(code))
			{
				return country;
			}
		}
		
		return null;
	}
}
