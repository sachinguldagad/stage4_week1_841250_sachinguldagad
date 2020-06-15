package com.example.employee.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;
import com.example.employee.exception.EmployeeNotFoundException;

@Service
public class DepartmentService {

	public ArrayList<Department> getAllDepartment()throws EmployeeNotFoundException
	{
		DepartmentDao emp=new DepartmentDao();
		
		return emp.getAllDepartment();
		
	}
	
}
