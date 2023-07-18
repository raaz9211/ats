package com.ai.ats.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;


@Getter
@Setter
@ToString
public class SubmissionDTO {


    long id;
    String submissionId;
    String recruiterName;
    String managerName;
    String jobName;
    String candidateName;
    String submissionStatus;
    Date submissionDate;
    String jobType;
    Date placementDate;
    Long rateOrSalary;
    String jobLocation;
    String visaType;
}
