package com.cognizant.HandsOn_2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.el.parser.ParseException;

@SpringBootApplication
public class HandsOn2Application {

	public static void main(String[] args) {
		SpringApplication.run(HandsOn2Application.class, args);
	}
	public void displayDate() throws ParseException, java.text.ParseException
	{
		 ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		 SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		 Date date=format.parse("31/12/2018");
		 String datestring=(String)format.format(date);
		 System.out.println(datestring);
	}

}
