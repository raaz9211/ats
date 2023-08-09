package com.ai.ats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hiring {

    private String senderEmail;
    private String candidateName;
    private String candidateEmail;
    private String candidateSubject;
    private String candidateJobDescription;
}
