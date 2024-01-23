package com.eion.jpa;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.eion.jpa.entity.customer.Customer;
import com.eion.jpa.entity.customer.PhoneNumber;
import com.eion.jpa.repository.CustomerRepository;

@SpringBootTest
public class CustomerTest {
  @Autowired
  private CustomerRepository customerRepository;

  @Test
  public void testCreateCustomer() {
    Customer john = Customer.builder()
        .name("John")
        .numbers(new HashSet<>())
        .build();

    john.getNumbers().add(PhoneNumber.builder()
        .number("212121212")
        .type("cell")
        .customer(john).build());

    john.getNumbers()
        .add(PhoneNumber.builder()
            .number("6565656565656")
            .type("home")
            .customer(john).build());

    customerRepository.save(john);

  }

  @Test
  @Transactional
  public void testLoadCustomer() {
    Customer customer = customerRepository.findById(252l).get();
    System.out.println(customer.getName());

    Set<PhoneNumber> numbers = customer.getNumbers();
    numbers.forEach(number -> System.out.println(number.getNumber()));
  }

  @Test
  public void testUpdateCustomer() {
    Customer customer = customerRepository.findById(252l).get();
    customer.setName("john bush");
    Set<PhoneNumber> numbers = customer.getNumbers();
    numbers.forEach(number -> number.setType("Mobile"));
    customerRepository.save(customer);
  }

  @Test
  public void testDelete() {
    customerRepository.deleteById(202l);
  }

}
