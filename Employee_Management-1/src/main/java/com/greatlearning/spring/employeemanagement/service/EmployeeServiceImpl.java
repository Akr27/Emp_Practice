package com.greatlearning.spring.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.spring.employeemanagement.exception.ResourceNotFoundException;
import com.greatlearning.spring.employeemanagement.model.Employee;
import com.greatlearning.spring.employeemanagement.repository.EmployeeRepo;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		Optional<Employee> employeeDb = this.employeeRepo.findById(employee.getId());
		
		if(employeeDb.isPresent()) {
			Employee employeeUpdate = employeeDb.get();
			employeeUpdate.setId(employee.getId());
			employeeUpdate.setFirstName(employee.getFirstName());
			employeeUpdate.setLastName(employee.getLastName());
			employeeUpdate.setEmail(employee.getEmail());
			employeeRepo.save(employeeUpdate);
			return employeeUpdate;
		}
		else {
			throw new ResourceNotFoundException("Record not found for id: "+employee.getId());
		}
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> employeeDb = this.employeeRepo.findById(id);
		
		if(employeeDb.isPresent()) {
			return employeeDb.get();
		}
		else {
			throw new ResourceNotFoundException("Record not found for id: "+id);
		}
		
	}

	@Override
	public void deleteEmployee(int id) {
		Optional<Employee> employeeDb = this.employeeRepo.findById(id);
		
		if(employeeDb.isPresent()) {
			this.employeeRepo.delete(employeeDb.get());
		}
		else {
			throw new ResourceNotFoundException("Record not found for id: "+id);
		}
	}
	
	@Override
	public List<Employee> getEmployeesSortedByFirstNameAsc(String firstName){
		return employeeRepo.findAll(Sort.by(Sort.Direction.ASC,firstName));
	}
	
	@Override
	public List<Employee> getEmployeesSortedByFirstNameDesc(String firstName){
		return employeeRepo.findAll(Sort.by(Sort.Direction.DESC,firstName));
	}
	
	

}
