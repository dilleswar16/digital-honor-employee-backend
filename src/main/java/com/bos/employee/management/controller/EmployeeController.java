package com.bos.employee.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bos.employee.management.model.Employee;
import com.bos.employee.management.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getallemployees")
	public List<Employee> getAllEmployessForAdmin() {
		System.out.println("In controller");
		List<Employee> employees = employeeService.getAllEmployeesForAdmin();
		return employees;
	}

	@GetMapping("/getemployee/{id}")
	public Optional<Employee> getEmployessForAdmin(@PathVariable long id) {
		Optional<Employee> employee = employeeService.getIndividualEmployee(id);
		return employee;
	}
	
	@PostMapping("/addemployee")
	public Employee saveEmployeeToDB(@RequestBody Employee emp) {
		//save student in DB
		Employee employee = employeeService.addEmployeeToDB(emp);
		return employee;

	}
	
	@PostMapping("/forgot/password")
	public String getPassword(@RequestBody Employee emp) {
		String pass = employeeService.getPassword(emp);
		return pass;
	}
	
	@PostMapping("/forgot/userid")
	public Object getUserId(@RequestBody Employee emp) {
		Object userId = employeeService.getUserId(emp);
		return userId;
	}
	
	@PatchMapping("/updateemployee/{id}")
	public Employee updateEmployee(@PathVariable long id,@RequestBody Employee emp) {
		Employee employee = employeeService.updateEmployee(id, emp);
		return employee;
		
	}
	
	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
		return "Successfully Deleted";
	}
	
	
	
	
}
