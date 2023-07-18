package com.ai.ats.entity.elastic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.stereotype.Component;

import java.util.List;

@Document(indexName = "candidates")
//@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Candidate {
    @Field(type = FieldType.Keyword)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Field(type = FieldType.Text)
    private String password;

    @Getter
    @Setter
    @Field(type = FieldType.Text)
    private String name;

    @Getter
    @Setter
    @Column(unique=true)
    @Field(type = FieldType.Text)
    private String email;

    @Getter
    @Setter
    @Field(type = FieldType.Text)
    private String phoneNo;

    @Getter
    @Setter
    @Field(type = FieldType.Text)
    private String address;

    @Getter
    @Setter
    @Field(type = FieldType.Text)
    private String summary;

    @Getter
    @Field(type = FieldType.Object, store = true)
    private List<Experience> experiences;

    @Getter
    @Field(type = FieldType.Object, store = true)
    private List<Education> educations;


    @Field(type = FieldType.Text, store = true)
    @Getter
    @Setter
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
