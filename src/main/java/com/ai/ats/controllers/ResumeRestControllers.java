package com.ai.ats.controllers;

import com.ai.ats.data.Education;
import com.ai.ats.data.Experience;
import com.ai.ats.data.User;
//import com.ai.ats.entities.Resume;
//import com.ai.ats.models.ResumeSearchResponse;
import com.ai.ats.data.UserDTO;
import com.ai.ats.entities.Resume;
import com.ai.ats.models.ResumeSearchResponse;
import com.ai.ats.repository.UserRepository;
import com.ai.ats.service.ResumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@RestController
@Slf4j
public class ResumeRestControllers {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    UserRepository userRepository;

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
    public ResponseEntity<List<ResumeSearchResponse>> searchResumes(@RequestParam String search) throws IOException {
        List<ResumeSearchResponse> response = resumeService.searchResumes(search);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("resume")
    public ResponseEntity<UserDTO> addResume(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(resumeService.addResume(userDTO),HttpStatus.CREATED);

    }
    @PostMapping("resumes")
    public ResponseEntity<List<UserDTO>> addAllResume(@RequestBody List<UserDTO> usersDTO) {
        return new ResponseEntity<>(resumeService.addAllResume(usersDTO),HttpStatus.CREATED);

    }

    @DeleteMapping("resume/{username}")
    public ResponseEntity<Long> deleteResumeByUsername(@PathVariable("username") String username) {

        return new ResponseEntity<>(resumeService.deleteUser(username), HttpStatus.NO_CONTENT);
    }

    @GetMapping("resume/{username}")
    public ResponseEntity<UserDTO> getResume(@PathVariable("username") String username) {
        return new ResponseEntity<>(resumeService.getResume(username), HttpStatus.ACCEPTED);
    }

    @GetMapping("resumes")
    public ResponseEntity<List<UserDTO>> getResumes() {
        return new ResponseEntity<>(resumeService.getAllResume(), HttpStatus.ACCEPTED);
    }


}
