package com.ai.ats.entity.jpa;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
@Component
@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;

    @Column(unique = true)
    private String username;
    @Column(name = "login_id")
    private String loginId;

    private String password;
    private String mobile;
    private String designation;
    @Column(name = "joining_date")
    @CreationTimestamp
    private OffsetDateTime joiningDate;
    @Column(name = "activation_status")
    private String activationStatus;
    @Column(name = "temp_id")
    private int tempId;

    @Column(name = "created_on")
    @CreationTimestamp
    private OffsetDateTime createdOn;

    @Column(name = "modified_on")
    @UpdateTimestamp
    private OffsetDateTime modifiedOn;

    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "is_registration_active")
    private boolean isRegistrationActive;

    @Getter(AccessLevel.NONE)
    @ManyToOne
    private CompanySetup companySetup;

    public boolean getIsRegistrationActive() {
        return isRegistrationActive;
    }

    public void setIsRegistrationActive(boolean isRegistrationActive) {
        this.isRegistrationActive = isRegistrationActive;
    }
}
