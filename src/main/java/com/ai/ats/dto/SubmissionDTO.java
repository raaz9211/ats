package com.ai.ats.dto;

import com.ai.ats.entity.jpa.PurchaseOrder;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Date;


@Getter
@Setter
@ToString
public class SubmissionDTO {
    private long submissionId;
    private String recruiterName;
    private String managerName;
    private String jobName;
    private String candidateName;
    private String submissionStatus;
    private OffsetDateTime submissionDate;
    private String jobType;
    private OffsetDateTime placementDate;
    private double salaryRate;
    private String jobLocation;
    private String visaType;
    private PurchaseOrderDTO purchaseOrder;
}
