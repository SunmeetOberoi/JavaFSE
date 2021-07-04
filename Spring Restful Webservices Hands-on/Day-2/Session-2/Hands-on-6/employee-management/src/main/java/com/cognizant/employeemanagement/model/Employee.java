package com.cognizant.employeemanagement.model;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Employee {

	@NotNull
	@Digits(fraction = 0, integer = 6, message = "ID must be less than 6 digits")
	private int id;

	@NotBlank
	@Size(min = 1, max = 30)
	private String name;

	@NotNull
	@Min(0)
	private Double salary;

	@NotNull
	private boolean permanent;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateofBirth;

	private Department department;
	private Set<Skill> skillList;
}
