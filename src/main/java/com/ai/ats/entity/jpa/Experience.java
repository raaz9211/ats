package com.ai.ats.entity.jpa;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Entity
@Table(name = "experiences")
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String title;
    private String company;
    private String location;
    private String duration;
    private List<String> responsibilities;

    @Getter(AccessLevel.NONE)
    @ManyToOne
    private Candidate candidate;




}
