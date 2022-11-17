package com.bos.employee.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bos.employee.management.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	@Query(
			  value = "SELECT * FROM EMPLOYEE U WHERE U.USER_ID =:userId", 
			  nativeQuery = true)
	Optional<Employee> findEmployeeForLogin(long userId);

	Optional<Employee> findByEmailId(String email);
	
	

}
