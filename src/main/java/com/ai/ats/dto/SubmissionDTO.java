package com.ai.ats.dto;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Data
public class SubmissionDTO {

    private long submissionId;
    private String jobPostingName;
    private String email;
    private String recruiterName;
    private String managerName;
    private String jobName;
    private String candidateName;
    private String submissionStatus;
    private OffsetDateTime submissionDate;
    private String jobType;
    private OffsetDateTime placementRate;
    private double salaryRate;
    private String jobLocation;
    private String visaType;
    private String client;
    private PurchaseOrderDTO purchaseOrder;

}
