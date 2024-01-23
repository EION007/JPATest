package com.eion.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eion.jpa.entity.Programmer.Programmer;

public interface ProgrammerRepository extends JpaRepository<Programmer, Integer> {

}
