package com.eion.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eion.jpa.entity.Payment.Check;
import com.eion.jpa.entity.Payment.CreditCard;
import com.eion.jpa.repository.PaymentRepository;

@SpringBootTest
public class PaymentTest {
  @Autowired
  private PaymentRepository paymentRepository;

  @Test
  public void createPayment() {
    CreditCard creditCard = new CreditCard();
    creditCard.setId(1237);
    creditCard.setAmount(1000);
    creditCard.setCardnumber("12121212121");

    Check ch = new Check();
    ch.setId(1238);
    ch.setAmount(1000);
    ch.setChecknumber("007");

    paymentRepository.save(creditCard);
    paymentRepository.save(ch);
  }
}
