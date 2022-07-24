package com.greatlearning.spring.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.spring.employeemanagement.model.Employee;
import com.greatlearning.spring.employeemanagement.repository.EmployeeRepo;

public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee=this.employeeRepo.findByEmail(username);
		
		if(employee==null) {
			throw new UsernameNotFoundException("No User Found");
		}
		return employee;
	}
	

}
