package com.ai.ats.entity.jpa;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@Entity
@Table(name = "purchase_orders")
@Data

public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "purchase_order_ID")
    long purchaseOrderID;


    @Column(name = "recruiter_name")
    private String recruiterName;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "candidate_name")
    private String candidateName;

    @Column(name = "submission_status")
    private String submissionStatus;

    @Column(name = "submission_date")
    @CreationTimestamp
    private OffsetDateTime submissionDate;


    @Column(name = "placement_date")
    @CreationTimestamp
    private OffsetDateTime placementDate;

    @Column(name = "salary_rate")
    private double salaryRate;

    @Column(name = "job_location")
    private String jobLocation;

    private String documentation;


    @Getter(AccessLevel.NONE)
//    @Setter(AccessLevel.NONE)
    @OneToOne
    private Submission submission;

}
