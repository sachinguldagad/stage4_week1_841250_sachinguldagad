package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	public ArrayList<Employee> getAllEmployees()
	{
		
		return employeeDao.getAllEmployees();
	}
	
	public void updateEmployee(Employee employee)
	{
		employeeDao.updateEmployee(employee);
		return;
	}
}
