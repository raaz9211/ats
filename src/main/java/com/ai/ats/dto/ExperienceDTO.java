package com.ai.ats.dto;

import lombok.*;

import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDTO {

    long id;
    String title;
    String company;
    String location;
    String duration;
    List<String> responsibilities;




}
