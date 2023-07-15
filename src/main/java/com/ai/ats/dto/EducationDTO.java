package com.ai.ats.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString

public class EducationDTO {

    long id;
    String degree;
    String university;
    String location;
    String graduationYear;


}
