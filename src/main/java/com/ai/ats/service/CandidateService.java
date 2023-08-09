package com.ai.ats.service;

import com.ai.ats.entity.jpa.Candidate;
import com.ai.ats.dto.CandidateDTO;
import com.ai.ats.exception.CandidateException;
import com.ai.ats.exception.CandidateNotFoundException;
import com.ai.ats.repository.CandidateJPARepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@Slf4j
public class CandidateService {


    private static final String RESUME_INDEX = "resumes";
    @Autowired
    ModelMapper modelMapper;


    @Autowired
    CandidateJPARepository candidateJPARepository;

    public CandidateDTO addCandidate(CandidateDTO candidateDTO) {

        Candidate candidate;
        try {
            candidate = candidateJPARepository.save(modelMapper.map(candidateDTO, Candidate.class));
            log.error("Candidate added");

        } catch (Exception e) {
            log.error("Add a valid Candidate ");
            throw new CandidateException("Candidate cant saved");

        }

        return modelMapper.map(candidate, CandidateDTO.class);
    }

    public List<CandidateDTO> addCandidates(List<CandidateDTO> usersDTO) {

        List<Candidate> candidates;
        try {
            candidates = (List<Candidate>) candidateJPARepository.saveAll( modelMapper.map(usersDTO,  new TypeToken<List<Candidate>>() {
            }.getType()));
            log.info("Candidates added");

        } catch (Exception e) {
            log.error("Add a valid Candidates");
            throw new CandidateException("Candidates cant saved");

        }

        return modelMapper.map(candidates, new TypeToken<List<CandidateDTO>>() {
        }.getType());
    }

    public CandidateDTO getCandidate(String email){

        return modelMapper.map(candidateJPARepository.findByEmail(email)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate Not found with email " + email)), CandidateDTO.class);


    }
    public List<CandidateDTO> getCandidates(){
        List<Candidate> candidates = (List<Candidate>) candidateJPARepository.findAll();
        return modelMapper.map(candidates, new TypeToken<List<CandidateDTO>>() {
        }.getType());

    }


    @Transactional
    public void deleteCandidate(String email){

        try {
            if(candidateJPARepository.deleteByEmail(email) == 0){
                throw new IllegalArgumentException();
            }
            log.info("Candidate deleted");
        } catch (Exception e){
            log.error("email not found");
            throw new CandidateNotFoundException("Candidate Not found with email " + email);

        }

    }
}
