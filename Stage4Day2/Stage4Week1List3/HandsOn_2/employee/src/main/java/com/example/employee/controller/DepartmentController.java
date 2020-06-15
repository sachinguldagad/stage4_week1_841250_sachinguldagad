package com.example.employee.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.Department;
import com.example.employee.service.DepartmentService;

@RestController
public class DepartmentController {

	@GetMapping("/departments")
	public ArrayList<Department>getAllDepartment()
	{
		DepartmentService departmentservice=new DepartmentService();
		ArrayList<Department>department=departmentservice.getAllDepartment();
		return department;
	}
}
