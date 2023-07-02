package com.ai.ats.service;

import com.ai.ats.entities.Resume;
import com.ai.ats.models.ResumeSearchResponse;

import java.io.IOException;
import java.util.List;

public interface ResumeService{

    boolean bulkInsertResumes(List<Resume> resumeList) throws IOException;

    List<ResumeSearchResponse> searchResumes(String search) throws IOException;

}
