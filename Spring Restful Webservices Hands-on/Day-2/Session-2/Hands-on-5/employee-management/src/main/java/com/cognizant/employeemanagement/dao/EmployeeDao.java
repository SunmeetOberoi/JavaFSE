package com.cognizant.employeemanagement.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.employeemanagement.exception.EmployeeNotFoundException;
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

	public void updateEmployee(Employee employee) {

		Optional<Employee> e = getAllEmployees().stream().filter(emp -> emp.getId() == employee.getId()).findFirst();
		if (e.isEmpty()) {
			throw new EmployeeNotFoundException();
		}
		EMPLOYEE_LIST.remove(e.get());
		EMPLOYEE_LIST.add(employee);
	}
}
