//package com.ai.ats.service;
//
//import com.ai.ats.dto.CandidateDTO;
//import com.ai.ats.dto.SubmissionDTO;
//import com.ai.ats.entitiy.Submission;
//import com.ai.ats.exception.CandidateException;
//import com.ai.ats.exception.CandidateNotFoundException;
//import com.ai.ats.exception.SubmissionNotFoundException;
//import com.ai.ats.repository.SubmissionRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//public class SubmissionService {
//
//    @Autowired
//    SubmissionRepository submissionRepository;
//    ModelMapper modelMapper = new ModelMapper();
//    public SubmissionDTO addSubmission(SubmissionDTO submissionDTO) {
//
//        Submission submission;
//        try {
//            submission = submissionRepository.save(modelMapper.map(submissionDTO, Submission.class));
//            log.error("Submission added");
//
//        } catch (Exception e) {
//            log.error("Add a valid submission ");
//            throw new CandidateException("submission can't saved");
//
//        }
//
//        return modelMapper.map(submission, SubmissionDTO.class);
//    }
//    public SubmissionDTO getSubmission(String submissionId){
//
//        return modelMapper.map(submissionRepository.findBySubmissionId(submissionId)
//                .orElseThrow(() -> new SubmissionNotFoundException("submission Not found with email " + submissionId)), SubmissionDTO.class);
//
//
//    }
//}
