package com.ai.ats.controllers;

import com.ai.ats.dto.CandidateDTO;
import com.ai.ats.service.CandidateElasticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@Slf4j
public class CandidateElasticRestControllers {


    @Autowired
    private CandidateElasticService candidateElasticService;


    @PostMapping("elastic/candidates")
    public ResponseEntity<String> bulkInsertCandidates(@RequestBody List<CandidateDTO> candidatesDto) throws IOException {
        boolean isSuccess = candidateElasticService.bulkInsertCandidates(candidatesDto);
        if (isSuccess) {
            return ResponseEntity.ok("Records successfully ingested!");
        } else {
            return ResponseEntity.internalServerError().body("Oops! unable to ingest data");
        }
    }

    @GetMapping("elastic/candidates")
    public ResponseEntity<List<CandidateDTO>> searchCandidates(@RequestParam String search) throws IOException {
        List<CandidateDTO> response = candidateElasticService.searchCandidates(search);
        return new ResponseEntity<>(response, HttpStatus.OK);


    }

}
