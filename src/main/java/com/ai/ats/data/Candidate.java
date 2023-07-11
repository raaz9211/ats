package com.ai.ats.data;

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
    long id;
    String password;
    String name;
    @Column(unique=true)
    String email;
    @Column(name = "phone_no")
    String phoneNo;
    String address;
    String summary;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Experience> experiences;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Education> educations;

    List<String> skills;

    public void setEducations(List<Education> educations) {
        educations.forEach(education -> education.setCandidate(this));
        this.educations = educations;
    }

    public void setExperiences(List<Experience> experiences) {
        experiences.forEach(experience -> experience.setCandidate(this));
        this.experiences = experiences;
    }

}
