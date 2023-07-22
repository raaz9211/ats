package com.ai.ats.dto;

import com.ai.ats.entity.jpa.Submission;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.List;


@Getter
@Setter
@ToString
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
    List<SubmissionDTO> submissions;
}
