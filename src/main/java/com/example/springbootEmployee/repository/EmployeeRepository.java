package com.example.springbootEmployee.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springbootEmployee.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	
}
