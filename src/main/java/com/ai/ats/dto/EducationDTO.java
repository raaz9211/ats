package com.ai.ats.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDTO {

    long id;
    String degree;
    String university;
    String location;
    String graduationYear;


}
