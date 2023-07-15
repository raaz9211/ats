package com.ai.ats.entitiy;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "submission")
@Getter
@Setter
@ToString
@Data
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String submissionId;

    private String recruiterName;

    private String managerName;
    private String jobName;

    private String candidateName;

    private String submissionStatus;
    private String submissionDate;
    private String jobType;

    private String placementDate;

    private Long salary;

    private String job_location;
    private String visaType;
}
