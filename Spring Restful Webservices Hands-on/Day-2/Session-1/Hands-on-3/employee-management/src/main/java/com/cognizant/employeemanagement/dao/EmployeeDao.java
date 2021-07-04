package com.cognizant.employeemanagement.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.employeemanagement.model.Employee;

@Repository
public class EmployeeDao {
	private static ArrayList<Employee> EMPLOYEE_LIST;

	public EmployeeDao() {
		if (EMPLOYEE_LIST == null) {
			ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
			EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
			((ClassPathXmlApplicationContext) context).close();
		}
	}

	public ArrayList<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}
}
