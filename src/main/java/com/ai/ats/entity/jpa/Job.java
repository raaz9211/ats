package com.ai.ats.entity.jpa;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;

@Component
@Entity
@Table(name = "jobs")
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_id")
    private long jobId;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "recruiter_name")
    private String recruiterName;

    @Column(name = "job_posting_date")
    @CreationTimestamp
    private OffsetDateTime jobPostingDate;

    @Column(name = "job_location")
    private String jobLocation;

    @Column(name = "salary_rate")
    private double salaryRate;

    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Submission> submissions;

    public void setSubmissions(List<Submission> submissions) {
        submissions.forEach(submission -> submission.setJob(this));
        this.submissions = submissions;
    }

}
