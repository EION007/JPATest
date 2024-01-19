package com.eion.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eion.jpa.entity.Employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
