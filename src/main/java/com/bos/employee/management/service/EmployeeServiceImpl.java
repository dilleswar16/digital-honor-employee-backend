package com.bos.employee.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bos.employee.management.model.Employee;
import com.bos.employee.management.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployeesForAdmin() {
		
//		System.out.println("In service");
		
		List<Employee> employees = employeeRepository.findAll();
//		System.out.println("in service after");
		return employees;
	}

	@Override
	public Optional<Employee> getIndividualEmployee(long id) {
		
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee;
	}

	@Override
	public Employee addEmployeeToDB(Employee emp) {
		return employeeRepository.save(emp);
		
		
	}

	@Override
	public Employee updateEmployee(long id,Employee emp) {
		Employee employee = employeeRepository.findById(id).get();
		employee.setRole(emp.getRole());
		employee.setFirstname(emp.getFirstname());
		employee.setLastname(emp.getLastname());
		employee.setEmailId(emp.getEmailId());
		employee.setDateOfBirth(emp.getDateOfBirth());
		employee.setDepartment(emp.getDepartment());
		employee.setMobileNo(emp.getMobileNo());
		employee.setAddress(emp.getAddress());
		
		employeeRepository.save(employee);
		
		return employee;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);;
		
	}

	@Override
	public Optional<Employee> getEmployeeForLogin(Employee employee) {
		long userId = employee.getUserId();
		Optional<Employee> emp = employeeRepository.findEmployeeForLogin(userId);
		
		if(emp.isPresent() && !(emp.get().getPassword().equals(employee.getPassword()))) {
			return emp;
		}
		if(emp.isEmpty()) {
//			System.out.println("Inside");
			return Optional.ofNullable(new Employee());
			
		}

		
		return emp;
		
	}

	@Override
	public String getPassword(Employee employee) {
		long id = employee.getUserId();
		Optional<Employee> emp = employeeRepository.findEmployeeForLogin(id);
		if(!(emp.isPresent())) {
			return null;
		}
		return emp.get().getPassword();
	}

	@Override
	public Object getUserId(Employee employee) {
		String email = employee.getEmailId();
		Optional<Employee> emp = employeeRepository.findByEmailId(email);
		if(!(emp.isPresent())) {
			System.out.println("null");
			System.out.println(email);
			return null;
			
		}
		System.out.println(email);
		return emp.get().getUserId();
	}
	
	

}
