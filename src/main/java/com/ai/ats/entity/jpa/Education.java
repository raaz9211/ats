package com.ai.ats.entity.jpa;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "educations")
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String degree;
    private String university;
    private String location;
    @Column(name = "graduation_year")
    private String graduationYear;

    @Getter(AccessLevel.NONE)
    @ManyToOne
    private Candidate candidate;

}
