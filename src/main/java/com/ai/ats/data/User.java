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
@Table(name = "users")
@Getter
@Setter
@ToString
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column(unique=true)
    String username;
    String password;
    String name;
    String email;
    @Column(name = "phone_no")
    String phoneNo;
    String address;
    String summary;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Experience> experiences;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Education> educations;

    List<String> skills;

    public void setEducations(List<Education> educations) {
        educations.forEach(education -> education.setUser(this));
        this.educations = educations;
    }

    public void setExperiences(List<Experience> experiences) {
        experiences.forEach(experience -> experience.setUser(this));
        this.experiences = experiences;
    }

}
