
package com.example.student_library_system.service;

import com.example.student_library_system.model.Card;
import com.example.student_library_system.model.Student;
import com.example.student_library_system.repository.StudentRepository;
import com.example.student_library_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    // Save Student
    public String saveStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();

        student.setName(studentRequestDto.getName());
        student.setDob(studentRequestDto.getDob());
        student.setDept(studentRequestDto.getDept());
        student.setEmail(studentRequestDto.getEmail());
        student.setGender(studentRequestDto.getGender());
        student.setSem(studentRequestDto.getSem());
        student.setMobile(studentRequestDto.getMobile());
        student.setAddress(studentRequestDto.getAddress());

        Card card = new Card();
        card.setCardStatus("Active");
        card.setExpiryDate(LocalDateTime.now().plusYears(3).toString());

        student.setCard(card);
        card.setStudent(student);

        studentRepository.save(student);

        return "Student saved successfully";
    }

    // Find Student By Id
    public Student getStudentById(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            return studentOptional.get();
        } else {
            throw new RuntimeException("Student not found with id : " + id);
        }
    }

    // Find All Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Pagination and Sorting
    public List<Student> getStudentByPage(int pageNo, int pageSize) {
        return studentRepository.findAll(
                PageRequest.of(pageNo, pageSize, Sort.by("name").ascending())
        ).getContent();
    }

    // Update Student
    public String updateStudent(int studentId, StudentRequestDto newStudentRequestDto) {
        Student existingStudent = getStudentById(studentId);

        existingStudent.setName(newStudentRequestDto.getName());
        existingStudent.setDob(newStudentRequestDto.getDob());
        existingStudent.setDept(newStudentRequestDto.getDept());
        existingStudent.setEmail(newStudentRequestDto.getEmail());
        existingStudent.setGender(newStudentRequestDto.getGender());
        existingStudent.setSem(newStudentRequestDto.getSem());
        existingStudent.setMobile(newStudentRequestDto.getMobile());
        existingStudent.setAddress(newStudentRequestDto.getAddress());

        studentRepository.save(existingStudent);

        return "Student updated successfully";
    }

    // Delete Student
    public String deleteStudentById(int id) {
        studentRepository.deleteById(id);
        return "Student with id " + id + " is deleted successfully!";
    }

    // Find Student By Email
    public Student getStudentByEmail(String email) {
        return studentRepository.getStudentByEmail(email);
    }

    // Find Students By Department
    public List<Student> getStudentByDept(String dept) {
        return studentRepository.getStudentByDept(dept);
    }
}
