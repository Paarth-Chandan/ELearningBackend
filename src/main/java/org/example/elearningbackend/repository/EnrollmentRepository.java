package org.example.elearningbackend.repository;

import org.example.elearningbackend.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    //List<Enrollment> findByStudentSId(Long studentId);
}
