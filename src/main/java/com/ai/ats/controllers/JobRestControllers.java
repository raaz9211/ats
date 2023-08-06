package com.ai.ats.controllers;

//import com.ai.ats.entities.Resume;
//import com.ai.ats.models.ResumeSearchResponse;
import com.ai.ats.dto.DocumentationDTO;
import com.ai.ats.dto.JobDTO;
import com.ai.ats.dto.PurchaseOrderDTO;
import com.ai.ats.dto.SubmissionDTO;
import com.ai.ats.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class JobRestControllers {

    @Autowired
    private JobService jobService;


    @PostMapping("job")
    public ResponseEntity<JobDTO> addJob(@RequestBody JobDTO jobDTO) {

        return new ResponseEntity<>(jobService.addJob(jobDTO),HttpStatus.CREATED);

    }
    @PutMapping("job/{jobId}")
    public ResponseEntity<JobDTO> updateJob(@RequestBody JobDTO jobDTO,@PathVariable("jobId") int jobId) {

        return new ResponseEntity<>(jobService.updateJob(jobId, jobDTO),HttpStatus.CREATED);

    }

    @GetMapping("job/{jobId}")
    public ResponseEntity<JobDTO> getJob(@PathVariable("jobId") int jobId) {
        return new ResponseEntity<>(jobService.getJob(jobId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("job/{jobId}")
    public ResponseEntity deleteJob(@PathVariable("jobId") int jobId) {
        jobService.deleteJob(jobId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("jobs")
    public ResponseEntity<List<JobDTO>> getJobs() {
        return new ResponseEntity<>(jobService.getJobs(), HttpStatus.ACCEPTED);
    }
    @PostMapping("job/{jobId}/submission")
    public ResponseEntity<JobDTO> addSubmission(@PathVariable("jobId") int jobId, @RequestBody SubmissionDTO submissionDTO) {
        System.out.println(submissionDTO);
        return new ResponseEntity<>(jobService.addSubmission(jobId, submissionDTO),HttpStatus.CREATED);

    }
    @DeleteMapping("job/{jobId}/submission/{submissionId}")
    public ResponseEntity deleteSubmission(@PathVariable("jobId") int jobId, @PathVariable("submissionId") int submissionId) {
        jobService.deleteSubmission(jobId, submissionId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @PostMapping("job/{jobId}/submission/{submissionId}/purchase-order")
    public ResponseEntity<JobDTO> addPurchaseOrder(@PathVariable("jobId") int jobId,@PathVariable("submissionId") int submissionId, @RequestBody PurchaseOrderDTO purchaseOrderDTO) {
        return new ResponseEntity<>(jobService.addPurchaseOrder(jobId, submissionId, purchaseOrderDTO),HttpStatus.CREATED);

    }

    @DeleteMapping("job/{jobId}/submission/{submissionId}/purchase-order")
    public ResponseEntity deletePurchaseOrder(@PathVariable("jobId") int jobId, @PathVariable("submissionId") int submissionId) {
        jobService.deletePurchaseOrder(jobId, submissionId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @PostMapping("job/{jobId}/submission/{submissionId}/purchase-order/documentation")
    public ResponseEntity<JobDTO> addDocumentation(@PathVariable("jobId") int jobId,@PathVariable("submissionId") int submissionId, @RequestBody DocumentationDTO documentationDTO) {
        return new ResponseEntity<>(jobService.addDocumentation(jobId, submissionId, documentationDTO),HttpStatus.CREATED);

    }
    @DeleteMapping("job/{jobId}/submission/{submissionId}/purchase-order/documentation")
    public ResponseEntity deleteDocumentation(@PathVariable("jobId") int jobId, @PathVariable("submissionId") int submissionId) {
        jobService.deleteDocumentation(jobId, submissionId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
