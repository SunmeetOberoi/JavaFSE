package com.cognizant.employeemanagement.model;

import java.util.Date;
import java.util.Set;

import lombok.Data;

@Data
public class Employee {
	private int id;
	private String name;
	private Double salary;
	private boolean permanent;
	private Date dateofBirth;
	private Department department;
	private Set<Skill> skillList;
}
