package com.ai.ats.service;

import com.ai.ats.dto.DocumentationDTO;
import com.ai.ats.dto.JobDTO;
import com.ai.ats.dto.PurchaseOrderDTO;
import com.ai.ats.dto.SubmissionDTO;
import com.ai.ats.entity.jpa.Job;
import com.ai.ats.exception.JobException;
import com.ai.ats.exception.JobNotFoundException;
import com.ai.ats.exception.SubmissionNotFoundException;
//import com.ai.ats.mapper.JobMapper;
import com.ai.ats.repository.JobJPARepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class JobService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    JobJPARepository jobJPARepository;

//    @Autowired
//    JobMapper jobMapper;


    public JobDTO addJob(JobDTO jobDTO) {
        jobDTO.setSubmissions(new ArrayList<>());
        Job job;
        try {
            job = jobJPARepository.save(modelMapper.map(jobDTO, Job.class));
            log.error("job added");

        } catch (Exception e) {
            log.error("Add a valid job ");
            throw new JobException("job cant saved");

        }

        return modelMapper.map(job, JobDTO.class);
    }

    public JobDTO getJob(int jobId) {

        return modelMapper.map(jobJPARepository.findById(jobId)
                .orElseThrow(() -> new JobNotFoundException("Job Not found with email " + jobId)), JobDTO.class);


    }

    public List<JobDTO> getJobs() {
        List<Job> candidates = (List<Job>) jobJPARepository.findAll();
        return modelMapper.map(candidates, new TypeToken<List<JobDTO>>() {
        }.getType());

    }

    @Transactional
    public void deleteJob(int jobId) {

        try {
            long t = jobJPARepository.deleteByJobId(jobId);
            if (t == 0) {
                throw new IllegalArgumentException();
            }
            log.info("Job deleted");
        } catch (Exception e) {
            log.error("Job Id not found");
            throw new JobNotFoundException("job Not found with  " + jobId);

        }


    }

    public JobDTO updateJob(int jobId, JobDTO jobDTO){
        JobDTO job = getJob(jobId);
        Job jobUpdated;
//        jobMapper.updateJobDTO(jobDTO, job);
        System.out.println(jobDTO);
        try {
            jobUpdated = jobJPARepository.save(modelMapper.map(job, Job.class));
            log.error("job updated");

        } catch (Exception e) {
            log.error("Add a valid job ");
            throw new JobException("job cant updated");

        }
        return modelMapper.map(jobUpdated, JobDTO.class);
    }

    public JobDTO addSubmission(int jobId, SubmissionDTO submissionDTO) {
        JobDTO jobDTO = getJob(jobId);
        Job job;
        try {
            jobDTO.getSubmissions().add(submissionDTO);
            job = jobJPARepository.save(modelMapper.map(jobDTO, Job.class));
            log.error("Submission added to jobId " + jobId);

        } catch (Exception e) {
            log.error("Submission not added to jobId " + jobId);
            e.printStackTrace();
            throw new JobException("Submission not added to jobId " + jobId);

        }
        return modelMapper.map(job, JobDTO.class);

    }
    public JobDTO deleteSubmission(int jobId, int submissionId) {
        JobDTO jobDTO = getJob(jobId);
        Job job;

        try {
            boolean isSubmission = jobDTO.getSubmissions().removeIf(submission -> submission.getSubmissionId() == submissionId);
            if(!isSubmission){
                throw new IllegalArgumentException();

            }
            job = jobJPARepository.save(modelMapper.map(jobDTO, Job.class));
            log.error("Submission deleted to jobId " + jobId);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new SubmissionNotFoundException("Submission not found "+submissionId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new JobException("Submission not deleted to jobId " + jobId);

        }
        return modelMapper.map(job, JobDTO.class);

    }

    public JobDTO addPurchaseOrder(int jobId, int submissionId, PurchaseOrderDTO purchaseOrderDTO) {
        JobDTO jobDTO = getJob(jobId);

        Job job;
        try {
            jobDTO.getSubmissions().stream().filter(submission -> submission.getSubmissionId() == submissionId).findAny()
                    .orElseThrow(() -> new SubmissionNotFoundException("submission Not found with submission " + submissionId))
                    .setPurchaseOrder(purchaseOrderDTO);

            job = jobJPARepository.save(modelMapper.map(jobDTO, Job.class));


        }catch (SubmissionNotFoundException e){
            log.error("PurchaseOrder added to jobId " + jobId);
            throw new SubmissionNotFoundException("submission Not found with submission " + submissionId);
        }
        catch (DataIntegrityViolationException e){
            log.error("PurchaseOrder is already present ");
            e.printStackTrace();
            throw new JobException("PurchaseOrder is already present");
        }
        catch (Exception e) {
            log.error("PurchaseOrder not added to jobId " + jobId);
            e.printStackTrace();
            throw new JobException("PurchaseOrder not added to jobId " + jobId);

        }
        return modelMapper.map(job, JobDTO.class);
    }

    public JobDTO deletePurchaseOrder(int jobId, int submissionId) {
        JobDTO jobDTO = getJob(jobId);

        Job job;
        try {
            jobDTO.getSubmissions().stream().filter(submission -> submission.getSubmissionId() == submissionId).findAny()
                    .orElseThrow(() -> new SubmissionNotFoundException("submission Not found with submission " + submissionId))
                    .setPurchaseOrder(null);

            job = jobJPARepository.save(modelMapper.map(jobDTO, Job.class));
            log.error("PurchaseOrder deleted to jobId " + jobId);

        }
        catch (Exception e) {
            log.error("PurchaseOrder not added to jobId " + jobId);
            e.printStackTrace();
            throw new JobException("PurchaseOrder not added to jobId " + jobId);

        }
        return modelMapper.map(job, JobDTO.class);
    }
    public JobDTO addDocumentation(int jobId, int submissionId, DocumentationDTO documentationDTO) {
        JobDTO jobDTO = getJob(jobId);

        Job job;
        try {
            jobDTO.getSubmissions().stream().filter(submission -> submission.getSubmissionId() == submissionId).findAny()
                    .orElseThrow(() -> new SubmissionNotFoundException("submission Not found with submission " + submissionId))
                    .getPurchaseOrder()
                    .setDocumentation(documentationDTO);
            System.out.println(modelMapper.map(jobDTO, Job.class));
            job = jobJPARepository.save(modelMapper.map(jobDTO, Job.class));
            log.error("documentation added to jobId " + jobId);

        } catch (NullPointerException e){
            log.error("PurchaseOrder is not present ");
            e.printStackTrace();
            throw new JobException("PurchaseOrder is not present");
        }
        catch (DataIntegrityViolationException e){
            log.error("documentation is already present ");
            e.printStackTrace();
            throw new JobException("documentation is already present");
        }
        catch (Exception e) {
            log.error("documentation not added to jobId " + jobId);
            e.printStackTrace();
            throw new JobException("documentation not added to jobId " + jobId);

        }
        return modelMapper.map(job, JobDTO.class);
    }
    public JobDTO deleteDocumentation(int jobId, int submissionId) {
        JobDTO jobDTO = getJob(jobId);

        Job job;
        try {
            jobDTO.getSubmissions().stream().filter(submission -> submission.getSubmissionId() == submissionId).findAny()
                    .orElseThrow(() -> new SubmissionNotFoundException("submission Not found with submission " + submissionId))
                    .getPurchaseOrder()
                    .setDocumentation(null);
            job = jobJPARepository.save(modelMapper.map(jobDTO, Job.class));
            log.error("documentation deleted to jobId " + jobId);

        } catch (NullPointerException e){
            log.error("PurchaseOrder is not present ");
            e.printStackTrace();
            throw new JobException("PurchaseOrder is not present");
        }
        catch (Exception e) {
            log.error("documentation not deleted to jobId " + jobId);
            e.printStackTrace();
            throw new JobException("documentation not deleted to jobId " + jobId);

        }
        return modelMapper.map(job, JobDTO.class);
    }

}
