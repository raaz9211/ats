package com.ai.ats.repository;

import com.ai.ats.entity.jpa.CompanyRegistration;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRegistrationJPARepository extends CrudRepository<CompanyRegistration, Integer> {

    long deleteByCompanyId(int companyId);
}

