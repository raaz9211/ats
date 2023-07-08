package com.ai.ats.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "resumes")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Resume {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String email;

    @Field(type = FieldType.Text)
    private String phoneNo;

    @Field(type = FieldType.Text)
    private String address;

    @Field(type = FieldType.Text)
    private String summary;

    @Field(type = FieldType.Text, store = true)
    private List<String> skills;

    @Field(type = FieldType.Object, store = true)
    private List<Experience> experiences;

    @Field(type = FieldType.Object, store = true)
    private List<Education> educations;

}
