package com.eion.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eion.jpa.entity.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
