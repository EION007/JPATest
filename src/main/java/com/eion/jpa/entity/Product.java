package com.eion.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
  @Id
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String desc;

  @Column(name = "price")
  private Double price;
}
