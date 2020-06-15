package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.EmployeeRestfulWebServiceApplication;
import com.cognizant.springlearn.entity.Employee;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;

@Service
public class EmployeeDao {

	private static ArrayList<Employee> EMPLOYEE_LIST;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestfulWebServiceApplication.class);
	
	public EmployeeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = context.getBean("employeeList", ArrayList.class);
	}

	public ArrayList<Employee> getAllEmployees()
	{
		LOGGER.info("Employee DAO method getAllEmployees() START");
		
		
		//EMPLOYEE_LIST.forEach(value->LOGGER.debug(value.toString()) );
		
		LOGGER.info("Employee DAO method getAllEmployees() END");
		return EMPLOYEE_LIST;
	}
	
	public void updateEmployee(Employee employee)
	{
		LOGGER.info("Employee DAO method updateEmployee() START");
		for(Employee emp : EMPLOYEE_LIST)
		{
			if(emp.getId()== employee.getId())
			{
				emp.setName(employee.getName());
				emp.setPermanent(employee.isPermanent());
				emp.setSalary(employee.getSalary());
				
				LOGGER.debug(emp.toString());
				return;
			}
		}
		LOGGER.info("Employee DAO method updateEmployee() END");
		
		throw new EmployeeNotFoundException();
		
	}
}
