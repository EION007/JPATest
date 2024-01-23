package com.eion.jpa.entity.Programmer;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
@Builder
public class Projects {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;

  @ManyToMany(mappedBy = "projects")
  private Set<Programmer> programmers;
}
