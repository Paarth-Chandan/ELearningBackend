package org.example.elearningbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course_completion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseCompletion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cc_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "s_id")
    @JsonIgnore
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id")
    @JsonIgnore
    private Course course;

    @Column(name = "videos_completed")
    private int videosCompleted;

    @Column(name = "total_videos")
    private int totalVideos;
}
