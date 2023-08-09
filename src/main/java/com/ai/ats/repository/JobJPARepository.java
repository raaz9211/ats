package com.ai.ats.repository;

import com.ai.ats.entity.jpa.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobJPARepository extends CrudRepository<Job, Integer> {

    long deleteByJobId(int jobId);
}

