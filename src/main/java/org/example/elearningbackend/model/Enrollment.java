package org.example.elearningbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ENROLLMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long e_id;

    @ManyToOne
    @JoinColumn(name = "s_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "c_id")
    private Course course;


}
