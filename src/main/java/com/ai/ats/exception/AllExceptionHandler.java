package com.ai.ats.exception;

import com.ai.ats.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(value = CandidateNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCandidateNotFoundException(CandidateNotFoundException candidateNotFoundException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(candidateNotFoundException.getMessage());
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CandidateException.class)
    public ResponseEntity<ExceptionResponse> handleCandidateException(CandidateException candidateException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(candidateException.getMessage());
        exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = JobException.class)
    public ResponseEntity<ExceptionResponse> handleJobException(JobException jobException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(jobException.getMessage());
        exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = JobNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleJobNotFoundException(JobNotFoundException jobNotFoundException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(jobNotFoundException.getMessage());
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = CompanyRegistrationException.class)
    public ResponseEntity<ExceptionResponse> handleRegistrationException(CompanyRegistrationException companyRegistrationException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(companyRegistrationException.getMessage());
        exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = CompanyRegistrationNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCompanyRegistrationNotFoundException(CompanyRegistrationNotFoundException companyRegistrationNotFoundException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(companyRegistrationNotFoundException.getMessage());
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = SubmissionNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleSubmissionNotFoundException(SubmissionNotFoundException submissionNotFoundException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(submissionNotFoundException.getMessage());
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(employeeNotFoundException.getMessage());
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = EmployeeException.class)
    public ResponseEntity<ExceptionResponse> handleEmployeeException(EmployeeException employeeException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(employeeException.getMessage());
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmailCantSendException.class)
    public ResponseEntity<ExceptionResponse> handleEmailCantSendException(EmailCantSendException emailCantSendException, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(emailCantSendException.getMessage());
        exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DocumentationNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleDocumentationNotFoundException(DocumentationNotFoundException documentationNotFoundException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(documentationNotFoundException.getMessage());
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = PurchaseOrderNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handlePurchaseOrderNotFoundException(PurchaseOrderNotFoundException purchaseOrderNotFoundException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(purchaseOrderNotFoundException.getMessage());
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = CompanySetupNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCompanySetupNotFoundException(CompanySetupNotFoundException companySetupNotFoundException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(companySetupNotFoundException.getMessage());
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = CompanySetupException.class)
    public ResponseEntity<ExceptionResponse> handleCompanySetupException(CompanySetupException companySetupException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(companySetupException.getMessage());
        exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
