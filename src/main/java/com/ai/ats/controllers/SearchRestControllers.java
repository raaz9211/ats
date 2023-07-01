package com.ai.ats.controllers;

import com.ai.ats.entities.Resume;
import com.ai.ats.models.ResumeSearchResponse;
import com.ai.ats.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class SearchRestControllers {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/resume/bulk")
    public ResponseEntity<String> bulkInsertResumes(@RequestBody List<Resume> resumes) throws IOException {
        boolean isSuccess = resumeService.bulkInsertResumes(resumes);
        if(isSuccess) {
            return ResponseEntity.ok("Records successfully ingested!");
        } else {
            return ResponseEntity.internalServerError().body("Oops! unable to ingest data");
        }
    }

    @GetMapping("/resume")
    public ResponseEntity<List<ResumeSearchResponse>> searchPage(@RequestParam String search) throws IOException {
        List<ResumeSearchResponse> response = resumeService.searchResumes(search);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping("/hi")
    public String hi(){
        return "hi";
    }

}
