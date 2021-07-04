package com.cognizant.employeemanagement.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Department {

	@NotNull
	@Digits(fraction = 0, integer = 6)
	private int id;

	@NotBlank
	@Size(min = 1, max = 30)
	private String name;
}
