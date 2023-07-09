package com.ai.ats.exception;

import com.ai.ats.data.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = CandidateNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCandidateNotFoundException(CandidateNotFoundException questionNotFoundException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(questionNotFoundException.getMessage());
        exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = CandidateException.class)
    public ResponseEntity<ExceptionResponse> handleQuestionException(CandidateException questionNotRemovedException, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(questionNotRemovedException.getMessage());
        exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.name());
        exceptionResponse.setTimestamp(new Date().toString());
        exceptionResponse.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }



}
