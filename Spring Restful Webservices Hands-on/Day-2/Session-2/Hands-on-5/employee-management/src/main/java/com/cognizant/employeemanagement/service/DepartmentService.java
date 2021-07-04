package com.cognizant.employeemanagement.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeemanagement.dao.DepartmentDao;
import com.cognizant.employeemanagement.model.Department;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentDao departmentDao;
	
	public ArrayList<Department> getAllDepartments(){
		return departmentDao.getAllDepartments();
	}
}
