package com.cognizant.springlearn;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayCountries();
	}
//	public static void displayCountry() throws ParseException {
//		
//LOGGER.info("START");
//		
//		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//		
//		Country country=(Country) context.getBean("country",Country.class);
//		Country anotherCountry = context.getBean("country", Country.class);	
//		LOGGER.debug("Country : {}", country.toString());
//		((ClassPathXmlApplicationContext)context).close();
//		LOGGER.info("END");
//	}
	public static void displayCountries()
	{
LOGGER.info("START");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries=context.getBean("countryList",ArrayList.class);
		for(Country country:countries)
		{
			LOGGER.debug("Country : {}", country.toString());
		}
		//LOGGER.debug("Country : {}", country.toString());
		((ClassPathXmlApplicationContext)context).close();
		LOGGER.info("END");

	}
}
