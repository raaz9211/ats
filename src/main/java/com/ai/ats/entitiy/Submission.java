package com.ai.ats.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.Id;
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
