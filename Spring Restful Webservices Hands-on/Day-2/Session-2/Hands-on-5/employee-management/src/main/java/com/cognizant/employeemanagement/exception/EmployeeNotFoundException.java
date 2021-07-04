package com.cognizant.employeemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Employee with the given id not found")
public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8046648554029880148L;

}
