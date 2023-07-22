package com.ai.ats.service;

import com.ai.ats.dto.JobDTO;
import com.ai.ats.dto.PurchaseOrderDTO;
import com.ai.ats.dto.SubmissionDTO;
import com.ai.ats.entity.jpa.Job;
import com.ai.ats.entity.jpa.Submission;
import com.ai.ats.exception.JobException;
import com.ai.ats.exception.JobNotFoundException;
import com.ai.ats.repository.JobRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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
    public List<JobDTO> getJobs(){
        List<Job> candidates = (List<Job>) jobRepository.findAll();
        return modelMapper.map(candidates, new TypeToken<List<JobDTO>>() {
        }.getType());

    }
    @Transactional
    public void deleteJob(int jobId){

        try {
            long t = jobRepository.deleteByJobId(jobId);
            if(t == 0){
                throw new IllegalArgumentException();
            }
            log.info("Job deleted");
        } catch (Exception e){
            log.error("Job Id not found");
            throw new JobNotFoundException("job Not found with  " + jobId);

        }

    }

    public JobDTO addSubmission(int jobId, SubmissionDTO submissionDTO){

        JobDTO jobDTO = getJob(jobId);
        Job job;
        boolean isSubmissionAdded = jobDTO.getSubmissions().add(submissionDTO);


        if(!isSubmissionAdded){
            throw new JobException("Submission not added to jobId " + jobId);
        }
        try {


            job = jobRepository.save(modelMapper.map(jobDTO, Job.class));
            log.error("Submission added to jobId " + jobId);

        } catch (Exception e) {
            log.error("Submission not added to jobId " + jobId);
            e.printStackTrace();
            throw new JobException("Submission not added to jobId " + jobId);

        }
        return modelMapper.map(job, JobDTO.class);

    }



}
