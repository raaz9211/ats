package com.ai.ats.dto;

import com.ai.ats.entity.jpa.CompanyRegistration;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class CompanySetupDTO {

    private long id;

    private String companyName;

    private String companyWebsite;

    private String companyEmail;

    private String companyPhoneNo;

    private OffsetDateTime licenseActivationDate;

    private OffsetDateTime licenseExpireDate;

    private String licenseType;

    private OffsetDateTime createdOn;

    private OffsetDateTime modifiedOn;

    private String createdBy;

    private String modifiedBy;

    @Column(name = "is_registration_active")
    private boolean isRegistrationActive;

    private List<EmployeeDTO> employees;

    public boolean getIsRegistrationActive() {
        return isRegistrationActive;
    }

    public void setIsRegistrationActive(boolean isRegistrationActive) {
        this.isRegistrationActive = isRegistrationActive;
    }


}
