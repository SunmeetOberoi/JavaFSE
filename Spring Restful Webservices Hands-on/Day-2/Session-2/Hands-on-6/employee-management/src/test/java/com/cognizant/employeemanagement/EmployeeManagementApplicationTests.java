package com.cognizant.employeemanagement;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.employeemanagement.controller.EmployeeController;
import com.cognizant.employeemanagement.model.Department;
import com.cognizant.employeemanagement.model.Employee;
import com.cognizant.employeemanagement.model.Skill;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeManagementApplicationTests {


	private static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	@Autowired
	EmployeeController employeeController;

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
		assertNotNull(employeeController);
	}

	@Test
	public void testUpdateEmployees_ValidInformation() throws Exception {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Ravi");
		emp.setSalary(100000.0);
		emp.setDateofBirth(Date.valueOf("1995-05-15"));
		emp.setPermanent(true);
		final ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		emp.setDepartment((Department) context.getBean("hr"));
		emp.setSkillList(
				new HashSet<Skill>(Arrays.asList((Skill) context.getBean("html"), (Skill) context.getBean("css"))));

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(emp);
		
		ResultActions actions = mvc
				.perform(put("/update-employee").contentType(APPLICATION_JSON_UTF8).content(requestJson));
		actions.andExpect(status().isOk());
	}

	@Test
	public void testGetCountryException() throws Exception {
		Employee emp = new Employee();
		emp.setId(10);
		emp.setName("Ravi");
		emp.setSalary(100000.0);
		emp.setDateofBirth(Date.valueOf("1995-05-15"));
		emp.setPermanent(true);
		final ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		emp.setDepartment((Department) context.getBean("hr"));
		emp.setSkillList(new HashSet<Skill>(Arrays.asList((Skill)context.getBean("html"), (Skill)context.getBean("css"))));

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(emp);
		
		ResultActions actions = mvc
				.perform(put("/update-employee").contentType(APPLICATION_JSON_UTF8).content(requestJson));
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Employee with the given id not found"));
	}

	@Test
	public void testGetCountry_InvalidDetails() throws Exception {
		Employee emp = new Employee();
		emp.setId(1234567);
		emp.setName("Ravi");
		emp.setSalary(100000.0);
		emp.setDateofBirth(Date.valueOf("1995-05-15"));
		emp.setPermanent(true);
		final ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		emp.setDepartment((Department) context.getBean("hr"));
		emp.setSkillList(new HashSet<Skill>(Arrays.asList((Skill)context.getBean("html"), (Skill)context.getBean("css"))));

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(emp);
		
		ResultActions actions = mvc
				.perform(put("/update-employee").contentType(APPLICATION_JSON_UTF8).content(requestJson));		actions.andExpect(status().isBadRequest());

		actions.andExpect(jsonPath("$.errors").exists());
		actions.andExpect(jsonPath("$.errors[0]").value("ID must be less than 6 digits"));
	}
}
