package com.ai.ats.repository;

import com.ai.ats.entity.jpa.Candidate;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CandidateJPARepository extends CrudRepository<Candidate, Integer> {
    Optional<Candidate> findByEmail(String email);
    long deleteByEmail(String email);

}

