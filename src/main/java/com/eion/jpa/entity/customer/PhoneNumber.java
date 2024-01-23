package com.eion.jpa.entity.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phone_number")
@Builder
public class PhoneNumber {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String number;
  private String type;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;
}
