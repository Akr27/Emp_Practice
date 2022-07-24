package com.greatlearning.spring.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.spring.employeemanagement.model.Employee;
import com.greatlearning.spring.employeemanagement.repository.EmployeeRepo;
import com.greatlearning.spring.employeemanagement.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/api/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return ResponseEntity.ok().body(employeeService.getAllEmployees());
		
	}
	
	@GetMapping("/api/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
		
	}
	
//	@GetMapping("/api/employees/search/{firstName}")
//	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String firstName){
//		return ResponseEntity.ok().body(employeeService.getEmployeeByName(firstName));
//		
//	}
	
	@PostMapping("/api/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok().body(this.employeeService.addEmployee(employee));
	}
	
	@PutMapping("/api/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee){
		employee.setId(id);
		return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
	}
	
	@DeleteMapping("/api/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id){
		this.employeeService.deleteEmployee(id);
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
	}
	
//	@GetMapping("/api/employees/sort?order=asc")
//	public ResponseEntity<List<Employee>> getEmployeesSortedByFirstNameAsc(String firstName){
//		List<Employee> sortedEmployees=employeeService.getEmployeesSortedByFirstNameAsc(firstName);
//		return ResponseEntity.ok().body(sortedEmployees);
//		
//	}
//	
//	@GetMapping("/api/employees/sort?order=desc")
//	public ResponseEntity<List<Employee>> getEmployeesSortedByFirstNameDesc(String firstName){
//		List<Employee> sortedEmployees=employeeService.getEmployeesSortedByFirstNameDesc(firstName);
//		return ResponseEntity.ok().body(sortedEmployees);
//		
//	}
	
	@GetMapping("/api/employees/sort?order=asc")
	public ResponseEntity<List<Employee>> getEmployeesSortedByFirstNameAsc(String firstName){
		return ResponseEntity.ok().body(employeeService.getEmployeesSortedByFirstNameAsc(firstName));
		
	}
	
	@GetMapping("/api/employees/sort?order=desc")
	public ResponseEntity<List<Employee>> getEmployeesSortedByFirstNameDesc(String firstName){
		return ResponseEntity.ok().body(employeeService.getEmployeesSortedByFirstNameDesc(firstName));
		
	}
	
	@Autowired
	EmployeeRepo empRepo;
	
	@GetMapping("/api/employees/search/{firstName}")
	public ResponseEntity<List<Employee>> getEmployeesByFirstName(@PathVariable String firstName){
		return new ResponseEntity<List<Employee>>(empRepo.findByFirstName(firstName),HttpStatus.OK);
	}
	
	
	
}
