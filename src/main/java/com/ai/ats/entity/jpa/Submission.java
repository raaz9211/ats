package com.ai.ats.entity.jpa;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@Entity
@Table(name = "submissions")
@Data
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "submission_id")
    private long submissionId;

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

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "placement_date")
    @CreationTimestamp
    private OffsetDateTime placementDate;

    @Column(name = "salary_rate")
    private double salaryRate;

    @Column(name = "job_location")
    private String jobLocation;

    @Column(name = "visa_type")
    private String visaType;

    @OneToOne(mappedBy = "submission", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PurchaseOrder purchaseOrder;

    @Getter(AccessLevel.NONE)
    @ManyToOne
    private Job job;

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrder.setSubmission(this);
        this.purchaseOrder = purchaseOrder;
    }
}
