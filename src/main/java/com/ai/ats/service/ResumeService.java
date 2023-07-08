package com.ai.ats.service;

import com.ai.ats.data.User;
import com.ai.ats.data.UserDTO;
import com.ai.ats.entities.Resume;
import com.ai.ats.models.ResumeSearchResponse;
//import com.ai.ats.entities.Resume;
//import com.ai.ats.models.ResumeSearchResponse;

import java.io.IOException;
import java.util.List;

public interface ResumeService{

    boolean bulkInsertResumes(List<Resume> resumeList) throws IOException;

    List<ResumeSearchResponse> searchResumes(String search) throws IOException;

    UserDTO addResume(UserDTO userDTO);
    UserDTO getResume(String username);

    List<UserDTO> addAllResume(List<UserDTO> usersDTO);
    long deleteUser(String username);
    List<UserDTO> getAllResume();

}
