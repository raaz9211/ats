package com.ai.ats.repository;

import com.ai.ats.entitiy.Resume;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends ElasticsearchRepository<Resume, String> {


}
