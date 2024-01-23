package com.eion.jpa;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eion.jpa.entity.Programmer.Programmer;
import com.eion.jpa.entity.Programmer.Projects;
import com.eion.jpa.repository.ProgrammerRepository;

@SpringBootTest
public class ProgrammerTest {
  @Autowired
  private ProgrammerRepository programmerRepository;

  @Test
  public void restCreateProgrammer() {
    Programmer programmer = new Programmer();
    programmer.setName("john");
    programmer.setSalary(50000);

    HashSet<Projects> projects = new HashSet<Projects>();
    Projects project = new Projects();
    project.setName("Hibernate project");
    projects.add(project);

    programmer.setProjects(projects);
    programmerRepository.save(programmer);
  }
}
