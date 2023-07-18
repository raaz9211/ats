//package com.ai.ats.entitiy;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//@Entity
//@Table(name = "Company_setup")
//@Getter
//@Setter
//@ToString
//public class CompanySetup {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    long id;
//    @Column(unique=true)
//    String mId;
//    String companyName;
//    String companyWebsite;
//    String companyEmail;
//    String CompanyMobile;
//    @Column(name = "license_activation_date")
//    @Temporal(TemporalType.DATE)
//    Date licenseActivationDate;
//    @Column(name = "license_expire_date")
//    @Temporal(TemporalType.DATE)
//    Date licenseExpireDate;
//    String licenseType;
//    @Column(name = "created_on")
//    @Temporal(TemporalType.DATE)
//    Date createdOn;
//    @Column(name = "modified_on")
//    @Temporal(TemporalType.DATE)
//    Date modifiedOn;
//    @Column(name = "created_by")
//    String createdBy;
//    @Column(name = "modified_by")
//    String modifiedBy;
//    boolean dStatus;
//
//}
