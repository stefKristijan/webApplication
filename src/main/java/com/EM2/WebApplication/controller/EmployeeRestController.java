package com.EM2.WebApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EM2.WebApplication.model.Employee;
import com.EM2.WebApplication.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(path="/employees", method=RequestMethod.GET)
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("id") int id){
		return employeeService.getEmployeeById(id);
	}

}