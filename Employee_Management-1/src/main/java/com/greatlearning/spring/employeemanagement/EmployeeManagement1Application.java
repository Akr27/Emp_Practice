package com.greatlearning.spring.employeemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.greatlearning.spring.employeemanagement.model.Employee;
import com.greatlearning.spring.employeemanagement.repository.EmployeeRepo;

@SpringBootApplication
public class EmployeeManagement1Application implements CommandLineRunner{
	
	@Autowired
	private EmployeeRepo employeeRepo;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagement1Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		Employee emp1=new Employee("John","Smith","johnsmith13@gmail.com","jsmith@13","NORMAL");
		this.employeeRepo.save(emp1);
		Employee emp2=new Employee("Claire","White","cwhite23@gmail.com","whitec23" , "NORMAL"); 
		this.employeeRepo.save(emp2);
		Employee emp3=new Employee("Harry","Ward","ward.harry87@rediffmail.com","hward_87", "NORMAL"); 
		this.employeeRepo.save(emp3);
		Employee emp4=new Employee("Tom","Hanks","tomhnks@gmail.com","thanks@99","NORMAL"); 
		this.employeeRepo.save(emp4);
		Employee emp5=new Employee("John","Bolton","johncbolton@gmail.com","j_bolt@27","NORMAL"); 
		this.employeeRepo.save(emp5);
		Employee emp6=new Employee("Frank","Mason","frank27889@yahoomail.com","m_frank","NORMAL"); 
		this.employeeRepo.save(emp6);
		Employee emp7=new Employee("Steve","Wang","steve.wang.27@gmail.com","sam_wang@9","NORMAL"); 
		this.employeeRepo.save(emp7);
		Employee emp8=new Employee("Tom","Brown","tbbrown@rediffmail.com","34_tbbrown","NORMAL"); 
		this.employeeRepo.save(emp8);
		Employee emp9=new Employee("Jane","Smith","janesmith.buisness@gmail.com","jsmith.buisness","ADMIN"); 
		this.employeeRepo.save(emp9);
		Employee emp10=new Employee("Arnold","Schrader","schrader.a@yahoomail.com","sch_arnold@85","NORMAL"); 
		this.employeeRepo.save(emp10);
	}

}
