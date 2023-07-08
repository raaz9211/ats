package com.ai.ats.models;

import com.ai.ats.entities.Education;
import com.ai.ats.entities.Experience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeSearchResponse {

    private String id;

    private String name;

    private String email;

    private String phoneNo;

    private String address;

    private String summary;

    private List<String> skills;

    private List<Experience> experiences;

    private List<Education> educations;
}
