package com.ai.ats.dto;

import com.ai.ats.entity.jpa.CompanySetup;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
@Data
public class EmployeeDTO {

    private int empId;

    private String username;
    private String loginId;

    private String password;
    private String mobile;
    private String designation;
    private OffsetDateTime joiningDate;
    private String activationStatus;
    private int tempId;
    private OffsetDateTime createdOn;
    private OffsetDateTime modifiedOn;
    private String createdBy;
    private String modifiedBy;
    private boolean isRegistrationActive;

    public boolean getIsRegistrationActive() {
        return isRegistrationActive;
    }

    public void setIsRegistrationActive(boolean isRegistrationActive) {
        this.isRegistrationActive = isRegistrationActive;
    }

}
