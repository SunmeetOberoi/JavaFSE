package com.cognizant.employeemanagement.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeemanagement.dao.EmployeeDao;
import com.cognizant.employeemanagement.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	public ArrayList<Employee> getAllEmployees(){
		return employeeDao.getAllEmployees();
	}
}
