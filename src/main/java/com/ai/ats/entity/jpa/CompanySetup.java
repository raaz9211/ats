package com.ai.ats.entity.jpa;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;

@Component
@Entity
@Table(name = "Company_setup")
@Data
public class CompanySetup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_website")
    private String companyWebsite;

    @Column(name = "company_email")
    private String companyEmail;

    @Column(name = "company_phone_no")
    private String companyPhoneNo;

    @Column(name = "license_activation_date")
    @CreationTimestamp
    private OffsetDateTime licenseActivationDate;

    @Column(name = "license_expire_date")
    @CreationTimestamp
    private OffsetDateTime licenseExpireDate;

    private String licenseType;

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

    @OneToMany(mappedBy = "companySetup", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;

    @Getter(AccessLevel.NONE)
    @OneToOne
    private CompanyRegistration companyRegistration;


    public boolean getIsRegistrationActive() {
        return isRegistrationActive;
    }

    public void setIsRegistrationActive(boolean isRegistrationActive) {
        this.isRegistrationActive = isRegistrationActive;
    }
    public void setEmployees(List<Employee> employees) {
        employees.forEach(employee -> employee.setCompanySetup(this));
        this.employees = employees;
    }
}
