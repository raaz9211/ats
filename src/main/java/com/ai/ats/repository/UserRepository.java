package com.ai.ats.repository;

import com.ai.ats.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    long deleteByUsername(String username);


}

