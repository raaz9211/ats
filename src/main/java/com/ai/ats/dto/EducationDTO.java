package com.ai.ats.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDTO {

    private long id;
    private String degree;
    private String university;
    private String location;
    private String graduationYear;


}
