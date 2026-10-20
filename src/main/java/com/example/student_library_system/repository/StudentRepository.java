
package com.example.student_library_system.repository;

import com.example.student_library_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM student WHERE email = :inputEmail", nativeQuery = true)
    Student getStudentByEmail(String inputEmail);

    @Query(value = "SELECT * FROM student WHERE dept = :inputDept", nativeQuery = true)
    List<Student> getStudentByDept(String inputDept);
}
