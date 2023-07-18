package com.ai.ats.entity.elastic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Education {
    @Field(type = FieldType.Keyword)
    @Getter
    @Setter
    private long id;

    @Field(type = FieldType.Text)
    @Getter
    @Setter
    private String degree;

    @Field(type = FieldType.Text)
    @Getter
    @Setter
    private String university;

    @Field(type = FieldType.Text)
    @Getter
    @Setter
    private String location;

    @Field(type = FieldType.Text)
    @Getter
    @Setter
    private String graduationYear;

    @Setter
    private Candidate candidate;


}
