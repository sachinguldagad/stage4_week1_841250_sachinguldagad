package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.EmployeeRestfulWebServiceApplication;
import com.cognizant.springlearn.entity.Department;
import com.cognizant.springlearn.entity.Employee;
import com.cognizant.springlearn.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService; 
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestfulWebServiceApplication.class);
	@GetMapping("/departments")
	public ArrayList<Department> getAllDepartments()
	{
		LOGGER.info("Deaprtment Controller method getAllEmployees()  START");
		
		
		LOGGER.info("Department Controller method getAllEmployees()  END");
		return departmentService.getAllDepartments();
	}
}
