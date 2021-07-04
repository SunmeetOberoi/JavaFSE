package com.cognizant.employeemanagement;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.employeemanagement.model.Employee;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}
