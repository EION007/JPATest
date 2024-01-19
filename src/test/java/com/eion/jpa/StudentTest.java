package com.eion.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import com.eion.jpa.entity.Student;
import com.eion.jpa.repository.StudentRepository;

@SpringBootTest
public class StudentTest {
  @Autowired
  private StudentRepository studentRepository;

  @Test
  public void testStudentCreate() {
    Student john = new Student();
    john.setFirstName("john");
    john.setLastName("sun");
    john.setScore(88);

    Student bill = new Student();
    bill.setFirstName("bill");
    bill.setLastName("gates");
    bill.setScore(90);

    studentRepository.save(john);
    studentRepository.save(bill);
  }

  @Test
  public void testFindAllStudents() {
    PageRequest pageRequest = PageRequest.of(0, 2);
    System.out.println(studentRepository.findAllStudents(pageRequest));
  }

  @Test
  public void testFindAllStudentsPartialData() {
    List<Object[]> students = studentRepository.findAllStudentsPartialData();
    for (Object[] objects : students) {
      System.out.println(objects[0]);
      System.out.println(objects[1]);

    }
  }

  @Test
  public void testFindAllStudentsByFirstName() {
    System.out.println(studentRepository.findAllStudentsByFirstName("john"));
  }

  @Test
  public void testFindAllStudentNQ() {
    System.out.println(studentRepository.findAllStudentNQ());
  }

  @Test
  public void testFindByFirstNQ() {
    System.out.println(studentRepository.findByFirstNQ("john"));
  }
}
