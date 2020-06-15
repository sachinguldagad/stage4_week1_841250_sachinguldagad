package com.example.employee.entity;

public class Employee {
	private String code;
	private String name;
	private String department;
	public Employee(String code, String name, String department) {
		super();
		this.code = code;
		this.name = name;
		this.department = department;
	}
	public Employee()
	{
		super();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [code=" + code + ", name=" + name + ", department=" + department + "]";
	}
	
	
}
