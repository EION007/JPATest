package com.eion.jpa.entity.Payment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {
  @Id
  private int id;
  private double amount;
}
