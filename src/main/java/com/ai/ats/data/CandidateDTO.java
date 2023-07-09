package com.ai.ats.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
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
