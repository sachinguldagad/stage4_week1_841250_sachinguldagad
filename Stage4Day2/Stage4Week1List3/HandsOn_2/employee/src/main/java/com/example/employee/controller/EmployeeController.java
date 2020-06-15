package com.example.employee.controller;

import java.beans.Transient;
import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.employee.EmployeeApplication;
import com.example.employee.entity.Employee;
import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.service.EmployeeDao;
import com.example.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	//private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(EmployeeApplication.class);
	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployees()throws EmployeeNotFoundException
	{
//		LOGGER.info("START");
		EmployeeService employeeservice=new EmployeeService();
		ArrayList<Employee> employee=employeeservice.getAllEmployees();
		return employee; 	
	}
	
//	@RequestMapping("/list")
//	public String tp()
//	{
//		//LOGGER.info("HIII");
//		return "HIII HELLOO do uor work properly";
//	}
}
