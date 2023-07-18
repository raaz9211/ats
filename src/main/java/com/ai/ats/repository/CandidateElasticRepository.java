package com.ai.ats.repository;

import com.ai.ats.entity.elastic.Candidate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateElasticRepository extends ElasticsearchRepository<Candidate, Long> {

}
