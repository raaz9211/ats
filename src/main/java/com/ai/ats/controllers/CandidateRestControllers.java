package com.ai.ats.controllers;

import com.ai.ats.dto.CandidateDTO;
import com.ai.ats.service.CandidateElasticService;
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
public class CandidateRestControllers {

    @Autowired
    private CandidateService candidateService;
    @Autowired
    private CandidateElasticService candidateElasticService;




    @PostMapping("candidate")
    public ResponseEntity<CandidateDTO> addCandidate(@RequestBody CandidateDTO candidateDTO) {
        return new ResponseEntity<>(candidateService.addCandidate(candidateDTO),HttpStatus.CREATED);

    }
    @PostMapping("candidates")
    public ResponseEntity<List<CandidateDTO>> addCandidates(@RequestBody List<CandidateDTO> candidatesDto) throws IOException {
        List<CandidateDTO> candidatesDtoSQLSaved = candidateService.addCandidates(candidatesDto);
        candidateElasticService.bulkInsertCandidates(candidatesDtoSQLSaved);
        return new ResponseEntity<>(candidatesDtoSQLSaved,HttpStatus.CREATED);

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
