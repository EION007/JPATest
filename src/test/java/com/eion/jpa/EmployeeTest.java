package com.eion.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eion.jpa.entity.Employee.Address;
import com.eion.jpa.entity.Employee.Employee;
import com.eion.jpa.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeTest {
  @Autowired
  private EmployeeRepository employeeRepository;

  @Test
  public void testCreateEmployee() {
    Employee john = new Employee();
    Address johnAddress = new Address();

    john.setId(123);
    john.setName("John");

    johnAddress.setCity("mangalore");
    johnAddress.setStreetAddress("shakthiangar");
    johnAddress.setCountry("india");
    johnAddress.setZipCode("575016");
    johnAddress.setState("Karnataka");

    john.setAddress(johnAddress);
    employeeRepository.save(john);
  }
}
