package com.greatlearning.spring.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.spring.employeemanagement.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	public List<Employee> findByFirstName(String firstName);
	public Employee findByEmail(String email);

}
