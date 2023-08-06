package com.ai.ats.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class JobDTO {
    private long jobId;
    private String jobName;
    private String jobDescription;
    private String managerName;
    private String recruiterName;
    private OffsetDateTime jobPostingDate;
    private String jobLocation;
    private double salaryRate;
    private List<SubmissionDTO> submissions;


}
