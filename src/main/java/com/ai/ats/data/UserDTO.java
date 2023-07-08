package com.ai.ats.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;


@Getter
@Setter
@ToString
public class UserDTO {

    long id;
    String username;
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
