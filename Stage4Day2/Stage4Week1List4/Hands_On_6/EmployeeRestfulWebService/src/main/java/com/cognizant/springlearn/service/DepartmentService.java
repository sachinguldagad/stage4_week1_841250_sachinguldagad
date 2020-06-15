package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.EmployeeRestfulWebServiceApplication;
import com.cognizant.springlearn.dao.DepartmentDao;
import com.cognizant.springlearn.entity.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestfulWebServiceApplication.class);
	
	public ArrayList<Department> getAllDepartments()
	{
		LOGGER.info("Department Service method getAllDepartments START");
		
		LOGGER.info("Department Service method getAllDepartments END");
		return departmentDao.getAllDepartments();
	}
}
