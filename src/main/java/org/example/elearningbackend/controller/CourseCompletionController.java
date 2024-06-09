package org.example.elearningbackend.controller;

import lombok.Data;
import org.example.elearningbackend.model.Course;
import org.example.elearningbackend.model.CourseCompletion;
import org.example.elearningbackend.model.Student;
import org.example.elearningbackend.repository.CourseCompletionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CourseCompletionController {

    @Autowired
    private CourseCompletionRepository courseCompletionRepository;

    @PostMapping("/courseCompletion/update")
    public ResponseEntity<CourseCompletion> updateCourseCompletion(@RequestBody CourseCompletionRequest request) {
        Long studentId = request.getStudentId();
        Long courseId = request.getCourseId();

        CourseCompletion courseCompletion = courseCompletionRepository.findByStudentAndCourse(studentId, courseId);
        if (courseCompletion == null) {
            courseCompletion = new CourseCompletion();
            courseCompletion.setStudent(new Student(studentId));
            courseCompletion.setCourse(new Course(courseId));
            courseCompletion.setVideosCompleted(1);  // Assuming this is the first video completed
            courseCompletion.setTotalVideos(6); // Assuming total number of videos is 6, you can adjust this as needed
        } else {
            courseCompletion.setVideosCompleted(courseCompletion.getVideosCompleted() + 1);
        }
        courseCompletion = courseCompletionRepository.save(courseCompletion);
        return ResponseEntity.ok(courseCompletion);
    }

    @GetMapping("/courseCompletion/{studentId}/{courseId}")
    public ResponseEntity<CourseCompletion> getCourseCompletion(@PathVariable Long studentId, @PathVariable Long courseId) {
        CourseCompletion courseCompletion = courseCompletionRepository.findByStudentAndCourse(studentId, courseId);
        if (courseCompletion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(courseCompletion);
    }

    @Data
    public static class CourseCompletionRequest {
        private Long studentId;
        private Long courseId;
    }
}
