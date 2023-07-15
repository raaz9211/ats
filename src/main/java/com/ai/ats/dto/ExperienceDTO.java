package com.ai.ats.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;



@Setter
@Getter
@ToString
public class ExperienceDTO {

    long id;
    String title;
    String company;
    String location;
    String duration;
    List<String> responsibilities;




}
