package org.example.elearningbackend.controller;

import lombok.Data;
import org.example.elearningbackend.model.Course;
import org.example.elearningbackend.model.Enrollment;
import org.example.elearningbackend.model.Student;
import org.example.elearningbackend.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @GetMapping("/enrollments")
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @GetMapping("/enrollment/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id) {
        Optional<Enrollment> enrollment = enrollmentRepository.findById(id);
        if(enrollment.isPresent()) {
            return new ResponseEntity<>(enrollment.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/enrollments/student/{studentId}")
//    public ResponseEntity<List<Enrollment>> getEnrollmentsByStudentId(@PathVariable Long studentId) {
//        List<Enrollment> enrollments = enrollmentRepository.findByStudentSId(studentId);
//        if (enrollments.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>(enrollments, HttpStatus.OK);
//        }
//    }

    @GetMapping("/enrollments/student/{studentId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByStudentId(@PathVariable Long studentId) {
        List<Enrollment> allEnrollments = enrollmentRepository.findAll();
        List<Enrollment> enrollments = allEnrollments.stream()
                .filter(enrollment -> enrollment.getStudent().getS_id().equals(studentId))
                .collect(Collectors.toList());

        return enrollments.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(enrollments);
    }


    @PostMapping("/enroll")
    public ResponseEntity<?> enroll(@RequestBody EnrollRequest enrollRequest) {
        try {
            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(new Student(enrollRequest.getStudentId()));
            enrollment.setCourse(new Course(enrollRequest.getCourseId()));
            Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEnrollment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to enroll student in course.");
        }
    }

    @Data
    static class EnrollRequest {
        private Long studentId;
        private Long courseId;
    }
}
