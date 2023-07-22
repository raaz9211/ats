package com.ai.ats.repository;

import com.ai.ats.entity.jpa.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Integer> {

    Long deleteByJobId(int jobId);
}

