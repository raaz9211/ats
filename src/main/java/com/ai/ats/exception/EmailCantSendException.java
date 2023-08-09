package com.ai.ats.exception;

public class EmailCantSendException extends RuntimeException {
    public EmailCantSendException(String message) {
        super(message);
    }
}
