package com.eion.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eion.jpa.entity.Payment.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
