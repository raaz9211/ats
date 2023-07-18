//package com.ai.ats.entitiy;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//@Entity
//@Table(name = "company_registration")
//@Getter
//@Setter
//@ToString
//public class CompanyRegistration {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    long sn;
//    @Column(unique=true)
//    String mId;
//    @Column(unique=true)
//    String username;
//    String password;
//    @Column(name = "phone_no")
//    String phoneNo;
//    @Column(name = "created_on")
//    @Temporal(TemporalType.DATE)
//    Date createdOn;
//    @Column(name = "modified_on")
//    @Temporal(TemporalType.DATE)
//    Date modifiedOn;
//    @Column(name = "d_status")
//    boolean dStatus;
//
//}
