package com.EM2.WebApplication.service;

import java.util.List;

import com.EM2.WebApplication.model.Employee;;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
}
