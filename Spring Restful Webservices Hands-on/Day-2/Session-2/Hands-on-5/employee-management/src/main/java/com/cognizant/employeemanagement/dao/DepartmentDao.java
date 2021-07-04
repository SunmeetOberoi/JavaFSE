package com.cognizant.employeemanagement.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.employeemanagement.model.Department;

@Repository
public class DepartmentDao {
	private static ArrayList<Department> DEPARTMENT_LIST;

	public DepartmentDao() {
		if (DEPARTMENT_LIST == null) {
			ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
			DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList");
			((ClassPathXmlApplicationContext) context).close();
		}
	}

	public ArrayList<Department> getAllDepartments() {
		return DEPARTMENT_LIST;
	}

}
