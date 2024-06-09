package org.example.elearningbackend.controller;

import lombok.Data;
import org.example.elearningbackend.model.Student;
import org.example.elearningbackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;


    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "Student added successfully";
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginCredentials credentials) {
        String email = credentials.getEmail();
        String password = credentials.getPassword();


        // Query the database to find a student with the matching email and password
        Student student = studentRepository.findByEmailAndPassword(email, password);

        if (student != null) {
            // Login successful, return a success message or a token
            return ResponseEntity.ok(student);
        } else {
            // Login failed, return an error message
            return ResponseEntity.ok(false);
        }
    }

    @Data
    static class LoginCredentials {
        private String email;
        private String password;
    }
}
