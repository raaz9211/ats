package com.ai.ats.service;

import com.ai.ats.dto.JobDTO;
import com.ai.ats.entity.jpa.Job;
import com.ai.ats.exception.JobException;
import com.ai.ats.exception.JobNotFoundException;
import com.ai.ats.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@Slf4j
public class JobService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    JobRepository jobRepository;


    public JobDTO addJob(JobDTO jobDTO) {
        jobDTO.setSubmissions(new ArrayList<>());
        Job job;
        try {
            job = jobRepository.save(modelMapper.map(jobDTO, Job.class));
            log.error("job added");

        } catch (Exception e) {
            log.error("Add a valid job ");
            throw new JobException("job cant saved");

        }

        return modelMapper.map(job, JobDTO.class);
    }

    public JobDTO getJob(int jobId){

        return modelMapper.map(jobRepository.findById(jobId)
                .orElseThrow(() -> new JobNotFoundException("Job Not found with email " + jobId)), JobDTO.class);


    }
//
//    public List<CandidateDTO> addCandidates(List<CandidateDTO> usersDTO) {
//
//        List<Candidate> candidates;
//        try {
//            candidates = (List<Candidate>) candidateRepository.saveAll( modelMapper.map(usersDTO,  new TypeToken<List<Candidate>>() {
//            }.getType()));
//            log.info("Candidates added");
//
//        } catch (Exception e) {
//            log.error("Add a valid Candidates");
//            throw new CandidateException("Candidates cant saved");
//
//        }
//
//        return modelMapper.map(candidates, new TypeToken<List<CandidateDTO>>() {
//        }.getType());
//    }
//
//    public List<CandidateDTO> getCandidates(){
//        List<Candidate> candidates = (List<Candidate>) candidateRepository.findAll();
//        return modelMapper.map(candidates, new TypeToken<List<CandidateDTO>>() {
//        }.getType());
//
//    }
//
//
//    @Transactional
//    public void deleteCandidate(String email){
//
//        try {
//            if(candidateRepository.deleteByEmail(email) == 0){
//                throw new IllegalArgumentException();
//            }
//            log.info("Candidate deleted");
//        } catch (Exception e){
//            log.error("email not found");
//            throw new CandidateNotFoundException("Candidate Not found with email " + email);
//
//        }
//
//    }
}
