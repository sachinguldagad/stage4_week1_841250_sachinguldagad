package com.example.employee.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


import com.example.employee.entity.Employee;
import com.example.employee.exception.EmployeeNotFoundException;
@Service
public class EmployeeDao {

	public Employee getAllEmployee(String code)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("employee.xml");
		ArrayList<Employee> listofemployee=context.getBean("employee_list",ArrayList.class);
		for(Employee employee:listofemployee)
		{
			if(employee.getCode().equalsIgnoreCase(code))
			{
				return employee;
			}
		}
//		return ;
	throw new EmployeeNotFoundException();
	}
}
