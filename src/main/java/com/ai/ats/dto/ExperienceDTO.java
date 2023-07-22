package com.ai.ats.dto;

import lombok.*;

import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDTO {

    private long id;
    private String title;
    private String company;
    private String location;
    private String duration;
    private List<String> responsibilities;




}
