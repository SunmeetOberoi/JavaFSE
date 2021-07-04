package com.cognizant.employeemanagement.controller;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PutMapping("/update-employee")
	public void updateEmployee(@RequestBody @Valid Employee e) {
		empService.updateEmployee(e);
	}
	
	@DeleteMapping("/delete-employee/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
		empService.deleteEmployee(id);
	}
}
