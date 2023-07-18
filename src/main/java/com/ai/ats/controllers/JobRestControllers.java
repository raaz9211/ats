package com.ai.ats.controllers;

//import com.ai.ats.entities.Resume;
//import com.ai.ats.models.ResumeSearchResponse;
import com.ai.ats.dto.JobDTO;
import com.ai.ats.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class JobRestControllers {

    @Autowired
    private JobService jobService;


    @PostMapping("job")
    public ResponseEntity<JobDTO> addJob(@RequestBody JobDTO jobDTO) {

        return new ResponseEntity<>(jobService.addJob(jobDTO),HttpStatus.CREATED);

    }
//    @PostMapping("candidates")
//    public ResponseEntity<List<CandidateDTO>> addCandidates(@RequestBody List<CandidateDTO> usersDTO) {
//        return new ResponseEntity<>(candidateService.addCandidates(usersDTO),HttpStatus.CREATED);
//
//    }
//
//    @DeleteMapping("candidate/{email}")
//    public ResponseEntity deleteCandidateByEmail(@PathVariable("email") String username) {
//        candidateService.deleteCandidate(username);
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
//
//    @GetMapping("candidate/{email}")
//    public ResponseEntity<CandidateDTO> getCandidate(@PathVariable("email") String username) {
//        return new ResponseEntity<>(candidateService.getCandidate(username), HttpStatus.ACCEPTED);
//    }
//
//    @GetMapping("candidates")
//    public ResponseEntity<List<CandidateDTO>> getCandidates() {
//        return new ResponseEntity<>(candidateService.getCandidates(), HttpStatus.ACCEPTED);
//    }


}
