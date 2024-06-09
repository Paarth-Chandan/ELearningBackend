package org.example.elearningbackend.repository;

import org.example.elearningbackend.model.CourseCompletion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseCompletionRepository extends JpaRepository<CourseCompletion, Long> {

    @Query("SELECT cc FROM CourseCompletion cc WHERE cc.student.s_id = :studentId AND cc.course.c_id = :courseId")
    CourseCompletion findByStudentAndCourse(@Param("studentId") Long studentId, @Param("courseId") Long courseId);
}
