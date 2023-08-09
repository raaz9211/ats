package com.ai.ats.controllers;

import com.ai.ats.dto.Hiring;
import com.ai.ats.service.HiringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmailRestControllers {

//    @Autowired
//    private JobLauncher jobLauncher;
//
//    @Autowired
//    private Job sendBulkEmailJob;
//

    @Autowired
    private HiringService hiringService;

    @PostMapping("/bulkmail")
    public ResponseEntity sendBulkHiringMail(@RequestBody List<Hiring> hirings){
        hiringService.sendBulkHiringMail(hirings);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
