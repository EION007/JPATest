
package com.eion.jpa.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import com.eion.jpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

  @Query("FROM Student")
  List<Student> findAllStudents(Pageable pageable);

  @Query("SELECT firstName, lastName FROM Student s ")
  List<Object[]> findAllStudentsPartialData();

  @Query("from Student where firstName=:firstName")
  List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);

  @Query(value = "select * from student", nativeQuery = true)
  List<Student> findAllStudentNQ();

  @Query(value = "select * from student where first_name=:firstName", nativeQuery = true)
  List<Student> findByFirstNQ(@Param("firstName") String firstName);
}