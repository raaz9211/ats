package com.ai.ats.repository;

import com.ai.ats.entities.Resume;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends ElasticsearchRepository<Resume, String> {


}
