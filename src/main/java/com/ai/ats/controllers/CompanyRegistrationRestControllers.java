package com.ai.ats.controllers;

import com.ai.ats.dto.*;
import com.ai.ats.service.CompanyRegistrationService;
import com.ai.ats.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class CompanyRegistrationRestControllers {

    @Autowired
    private CompanyRegistrationService companyRegistrationService;


    @PostMapping("company-registration")
    public ResponseEntity<CompanyRegistrationDTO> addCompanyRegistration(@RequestBody CompanyRegistrationDTO companyRegistrationDTO) {
        return new ResponseEntity<>(companyRegistrationService.addCompanyRegistration(companyRegistrationDTO),HttpStatus.CREATED);
    }
    @GetMapping("company-registration/{companyId}")
    public ResponseEntity<CompanyRegistrationDTO> getCompanyRegistration(@PathVariable("companyId") int companyId) {
        return new ResponseEntity<>(companyRegistrationService.getCompanyRegistration(companyId), HttpStatus.ACCEPTED);
    }

    @GetMapping("company-registrations")
    public ResponseEntity<List<CompanyRegistrationDTO>> getCompanyRegistrations() {
        return new ResponseEntity<>(companyRegistrationService.getCompanyRegistrations(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("company-registration/{companyId}")
    public ResponseEntity deleteCompanyRegistration(@PathVariable("companyId") int companyId) {
        companyRegistrationService.deleteCompanyRegistration(companyId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @PostMapping("company-registration/{companyId}/company-setup")
    public ResponseEntity<CompanyRegistrationDTO> addCompanySetup(@PathVariable("companyId") int companyId, @RequestBody CompanySetupDTO companySetupDTO) {
        return new ResponseEntity<>(companyRegistrationService.addCompanySetup(companyId, companySetupDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("company-registration/{companyId}/company-setup")
    public ResponseEntity deleteCompanySetup(@PathVariable("companyId") int companyId) {
        companyRegistrationService.deleteCompanySetup(companyId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping("company-registration/{companyId}/company-setup/employee")
    public ResponseEntity<CompanyRegistrationDTO> addEmployee(@PathVariable("companyId") int companyId, @RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(companyRegistrationService.addEmployee(companyId, employeeDTO),HttpStatus.CREATED);
    }

    @GetMapping("company-registration/{companyId}/company-setup/employees")
    public ResponseEntity<List<EmployeeDTO>> getEmployees(@PathVariable("companyId") int companyId) {
        return new ResponseEntity<>(companyRegistrationService.getEmployees(companyId),HttpStatus.CREATED);
    }
    @GetMapping("company-registration/{companyId}/company-setup/employee/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("companyId") int companyId, @PathVariable("employeeId") int employeeId) {
        return new ResponseEntity<>(companyRegistrationService.getEmployee(companyId, employeeId),HttpStatus.CREATED);
    }
    @DeleteMapping("company-registration/{companyId}/company-setup/employee/{employeeId}")
    public ResponseEntity deleteEmployee(@PathVariable("companyId") int companyId, @PathVariable("employeeId") int employeeId) {
        companyRegistrationService.deleteEmployee(companyId, employeeId);
        return new ResponseEntity(HttpStatus.CREATED);
    }


//    @PostMapping("job/{jobId}/submission/{submissionId}")
//    public ResponseEntity<JobDTO> addPurchaseOrder(@PathVariable("jobId") int jobId,@PathVariable("submissionId") int submissionId, @RequestBody PurchaseOrderDTO purchaseOrderDTO) {
//        return new ResponseEntity<>(jobService.addPurchaseOrder(jobId, submissionId, purchaseOrderDTO),HttpStatus.CREATED);
//
//    }
//




}
