package com.cognizant.employeemanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeemanagement.model.Employee;
import com.cognizant.employeemanagement.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}
}
