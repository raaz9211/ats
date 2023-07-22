package com.ai.ats.entity.jpa;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Table(name = "candidates")
@Getter
@Setter
@ToString
@Data
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String password;
    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "phone_no")
    private String phoneNo;
    private String address;
    private String summary;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Experience> experiences;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Education> educations;

    private List<String> skills;

    public void setEducations(List<Education> educations) {
        educations.forEach(education -> education.setCandidate(this));
        this.educations = educations;
    }

    public void setExperiences(List<Experience> experiences) {
        experiences.forEach(experience -> experience.setCandidate(this));
        this.experiences = experiences;
    }

}
