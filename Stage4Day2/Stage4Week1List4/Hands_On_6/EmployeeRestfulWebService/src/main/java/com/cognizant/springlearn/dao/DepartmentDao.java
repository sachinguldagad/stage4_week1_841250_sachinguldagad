package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.EmployeeRestfulWebServiceApplication;
import com.cognizant.springlearn.entity.Department;

@Service
public class DepartmentDao {

	private static ArrayList<Department> DEPARTMENT_LIST; 
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestfulWebServiceApplication.class);
	
	
	public ArrayList<Department> getAllDepartments()
	{
		LOGGER.info("Department DAO method getAllDepartments START");
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = context.getBean("departmentList",ArrayList.class);
		
		
		LOGGER.info("Department DAO method getAllDepartments END");
		return DEPARTMENT_LIST;
	}
}
