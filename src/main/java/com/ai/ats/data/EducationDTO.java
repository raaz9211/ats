package com.ai.ats.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;



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
