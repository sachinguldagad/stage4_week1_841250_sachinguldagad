package com.example.employee.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;

public class DepartmentDao {

	public ArrayList<Department> getAllDepartment() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		
		ArrayList<Department> listOfCountries = new ArrayList<Department>();
		listOfCountries = context.getBean("departmentList", ArrayList.class);
		// TODO Auto-generated method stub
		
		return listOfCountries;
	}

}
