package com.ai.ats.repository;

import com.ai.ats.data.Candidate;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Candidate, Integer> {
    Optional<Candidate> findByEmail(String email);

    Long deleteByEmail(String email);


}

