package com.ai.ats.entity.elastic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Experience {

    @Field(type = FieldType.Keyword)
    @Getter
    @Setter
    long id;

    @Field(type = FieldType.Text)
    @Getter
    @Setter
    private String title;

    @Field(type = FieldType.Text)
    @Getter 
    @Setter
    private String company;

    @Field(type = FieldType.Text)
    @Getter 
    @Setter
    private String location;

    @Field(type = FieldType.Text)
    @Getter 
    @Setter
    private String duration;

    @Field(type = FieldType.Text, store = true)
    @Getter 
    @Setter
    private List<String> responsibilities;

    @Setter
    private Candidate candidate;



}
