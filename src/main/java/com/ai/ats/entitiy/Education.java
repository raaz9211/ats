package com.ai.ats.entitiy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "educations")
@Setter
@Getter
@ToString
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String degree;
    String university;
    String location;
    @Column(name = "graduation_year")
    String graduationYear;

    @ManyToOne
    Candidate candidate;

}
