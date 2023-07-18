package com.ai.ats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO {

    long id;
    String password;
    String name;
    String email;
    String phoneNo;
    String address;
    String summary;

    List<ExperienceDTO> experiences;
    List<EducationDTO> educations;
    List<String> skills;



}
