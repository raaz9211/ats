package com.ai.ats.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExceptionResponse {

    private String timestamp;
    private String error;
    private String status;
    private String path;
}

