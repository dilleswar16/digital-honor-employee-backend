package com.bos.employee.management.service;

import java.util.List;
import java.util.Optional;

import com.bos.employee.management.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployeesForAdmin();
	
	Optional<Employee> getIndividualEmployee(long id);

	Employee addEmployeeToDB(Employee emp);


	Employee updateEmployee(long id, Employee emp);

	void deleteEmployee(long id);
	
	Optional<Employee> getEmployeeForLogin(Employee employee);

	String getPassword(Employee emp);

	Object getUserId(Employee emp);
}
