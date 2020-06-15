package com.example.employee.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	
	public ArrayList<Employee> getAllEmployees()throws EmployeeNotFoundException
	{
		EmployeeDao emp=new EmployeeDao();
		
		return emp.getAllEmployees();
		
	}
	

}
