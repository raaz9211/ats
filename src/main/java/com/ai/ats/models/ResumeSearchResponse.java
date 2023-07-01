package com.ai.ats.models;

import com.ai.ats.entities.Education;
import com.ai.ats.entities.Experience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeSearchResponse {

    private String id;

    private String name;

    private String email;

    private String phone;

    private List<String> skills;

    private List<Experience> experiences;

    private List<Education> educations;
}
