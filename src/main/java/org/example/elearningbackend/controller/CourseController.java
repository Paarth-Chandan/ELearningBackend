package org.example.elearningbackend.controller;

import org.example.elearningbackend.model.Course;
import org.example.elearningbackend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        return courseOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
