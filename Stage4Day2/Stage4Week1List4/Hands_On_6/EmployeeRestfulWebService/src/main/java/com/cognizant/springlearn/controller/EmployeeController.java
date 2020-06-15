package com.cognizant.springlearn.controller;

import java.net.URI;
import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cognizant.springlearn.EmployeeRestfulWebServiceApplication;
import com.cognizant.springlearn.entity.Employee;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.service.EmployeeService;

@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestfulWebServiceApplication.class);
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployees()
	{
		LOGGER.info("Employee Controller method getAllEmployees()  START");
		
		LOGGER.info("Employee Controller method getAllEmployees() END");
		return employeeService.getAllEmployees();
	}
	
	@PutMapping("/employees")
	public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException
	{
		LOGGER.info("Employee Controller method updateEmployee()  START");
		employeeService.updateEmployee(employee);
		LOGGER.info("Employee Controller method updateEmployee() END");
		
	}
	@DeleteMapping("/employees")
	public void deleteEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException
	{
		LOGGER.info("Employee Controller method void deleteEmployee(@RequestBody @Valid Employee employee)  START");
		employeeService.deleteEmployee(employee);
		LOGGER.info("Employee Controller method void deleteEmployee(@RequestBody @Valid Employee employee) END");
		
	}
	
}
