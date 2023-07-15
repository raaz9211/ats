package com.ai.ats.controllers;

//import com.ai.ats.entities.Resume;
//import com.ai.ats.models.ResumeSearchResponse;
import com.ai.ats.dto.CandidateDTO;
import com.ai.ats.entitiy.Resume;
import com.ai.ats.models.ResumeSearchResponse;
import com.ai.ats.service.CandidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;



@RestController
@Slf4j
public class ResumeRestControllers {

    @Autowired
    private CandidateService candidateService;


    @PostMapping("/resume/bulk")
    public ResponseEntity<String> bulkInsertResumes(@RequestBody List<Resume> resumes) throws IOException {
        boolean isSuccess = candidateService.bulkInsertResumes(resumes);
        if(isSuccess) {
            return ResponseEntity.ok("Records successfully ingested!");
        } else {
            return ResponseEntity.internalServerError().body("Oops! unable to ingest data");
        }
    }

    @GetMapping("/resume")
    public ResponseEntity<List<ResumeSearchResponse>> searchResumes(@RequestParam String search) throws IOException {
        List<ResumeSearchResponse> response = candidateService.searchResumes(search);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("candidate")
    public ResponseEntity<CandidateDTO> addCandidate(@RequestBody CandidateDTO candidateDTO) {
        return new ResponseEntity<>(candidateService.addCandidate(candidateDTO),HttpStatus.CREATED);

    }
    @PostMapping("candidates")
    public ResponseEntity<List<CandidateDTO>> addCandidates(@RequestBody List<CandidateDTO> usersDTO) {
        return new ResponseEntity<>(candidateService.addCandidates(usersDTO),HttpStatus.CREATED);

    }

    @DeleteMapping("candidate/{email}")
    public ResponseEntity deleteCandidateByEmail(@PathVariable("email") String username) {
        candidateService.deleteCandidate(username);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("candidate/{email}")
    public ResponseEntity<CandidateDTO> getCandidate(@PathVariable("email") String username) {
        return new ResponseEntity<>(candidateService.getCandidate(username), HttpStatus.ACCEPTED);
    }

    @GetMapping("candidates")
    public ResponseEntity<List<CandidateDTO>> getCandidates() {
        return new ResponseEntity<>(candidateService.getCandidates(), HttpStatus.ACCEPTED);
    }


}
