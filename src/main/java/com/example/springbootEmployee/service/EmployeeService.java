package com.example.springbootEmployee.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootEmployee.entity.Employee;
import com.example.springbootEmployee.exception.EmployeeAlreadyExistsException;
import com.example.springbootEmployee.repository.EmployeeRepository;


@Service

public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	public Employee saveEmployee(Employee e) throws EmployeeAlreadyExistsException {
	
		List<Employee> l = (List<Employee>) repo.findAll();
		for (Employee s : l) {
			 if(e.getId() == s.getId()){
				 throw new EmployeeAlreadyExistsException("Employee with the given ID already Exists in the database");
				 
			 }
			
		}
	    return repo.save(e);
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> l = (List<Employee>) repo.findAll();
		Collections.sort(l, new ComparatorSalary());
		return l;
		
	}
	
	public Employee updateEmployee(Employee d,int id,Double salary) {
	      Optional<Employee> e = repo.findById(id);
	      Employee e1 = e.get();
	      e1.setSalary(d.getSalary());
	      repo.save(e1);
	      
	      return e1;
	}

}
