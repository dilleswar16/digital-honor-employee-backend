package com.bos.employee.management.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bos.employee.management.model.Employee;
import com.bos.employee.management.service.EmployeeService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class LoginController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("login/admin")
	public Optional<Employee> adminLogin(@RequestBody Employee employee) {
		
		return employeeService.getEmployeeForLogin(employee);
		
		
	}

}
