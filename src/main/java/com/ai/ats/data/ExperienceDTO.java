package com.ai.ats.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

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
