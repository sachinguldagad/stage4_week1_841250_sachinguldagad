package com.example.employee.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.example.employee.entity.Employee;
import com.example.employee.exception.EmployeeNotFoundException;
@Component
public class EmployeeDao {

	public ArrayList<Employee> getAllEmployees()throws EmployeeNotFoundException
	{
//		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		
		ArrayList<Employee> listOfCountries = new ArrayList<Employee>();
		listOfCountries = context.getBean("employee_list", ArrayList.class);
		
	//	LOGGER.info("END");
		return listOfCountries; 	
	}
}
