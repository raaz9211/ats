package com.ai.ats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO {

    private long id;
    private String password;
    private String name;
    private String email;
    private String phoneNo;
    private String address;
    private String summary;

    private List<ExperienceDTO> experiences;
    private List<EducationDTO> educations;
    private List<String> skills;


}
