package com.greatlearning.spring.employeemanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "Home Page";
	}
	
	@GetMapping("/login")
	public String login() {
		return "Login Page";
	}
	
	@GetMapping("/register")
	public String register() {
		return "Register Page";
	}

}
