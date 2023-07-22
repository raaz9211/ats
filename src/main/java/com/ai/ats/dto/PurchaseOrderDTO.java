package com.ai.ats.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@Data

public class PurchaseOrderDTO {

    long purchaseOrderID;


    private String recruiterName;
    private String managerName;
    private String jobName;
    private String candidateName;
    private String submissionStatus;
    private OffsetDateTime submissionDate;
    private OffsetDateTime placementDate;
    private double salaryRate;
    private String jobLocation;
    private String documentation;

}
