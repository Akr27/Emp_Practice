package com.greatlearning.spring.employeemanagement.service;

import java.util.List;

import com.greatlearning.spring.employeemanagement.model.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
//	List<Employee> getEmployeeByName(String firstName);
	void deleteEmployee(int id);
	List<Employee> getEmployeesSortedByFirstNameAsc(String firstName);
	List<Employee> getEmployeesSortedByFirstNameDesc(String firstName);
//	List<Employee> getEmployeesByFirstName(String firstName);
}
