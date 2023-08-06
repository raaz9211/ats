package com.ai.ats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;

@Data
public class CompanyRegistrationDTO {

    private long companyId;
    private String username;
    private String password;
    private String phoneNo;
    private OffsetDateTime createdOn;
    private OffsetDateTime modifiedOn;
    private boolean isRegistrationActive;
    private CompanySetupDTO companySetup;


    public boolean getIsRegistrationActive() {
        return isRegistrationActive;
    }

    public void setIsRegistrationActive(boolean isRegistrationActive) {
        this.isRegistrationActive = isRegistrationActive;
    }
}
