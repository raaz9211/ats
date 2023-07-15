package com.ai.ats.repository;

import com.ai.ats.entitiy.Candidate;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
    Optional<Candidate> findByEmail(String email);
    Long deleteByEmail(String email);

}

