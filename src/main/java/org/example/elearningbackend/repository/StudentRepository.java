package org.example.elearningbackend.repository;

import org.example.elearningbackend.model.Enrollment;
import org.example.elearningbackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);

    Student findByEmailAndPassword(String email, String password);
}
