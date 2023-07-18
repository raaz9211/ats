package com.ai.ats.entity.jpa;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Entity
@Table(name = "experiences")
@Setter
@Getter
@ToString
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String company;
    String location;
    String duration;
    List<String> responsibilities;

    @ManyToOne
    Candidate candidate;




}
