package com.ai.ats.controllers;

import com.ai.ats.dto.HiringDTO;
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
    public ResponseEntity sendBulkHiringMail(@RequestBody List<HiringDTO> hiringDTOS){
        hiringService.sendBulkHiringMail(hiringDTOS);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
