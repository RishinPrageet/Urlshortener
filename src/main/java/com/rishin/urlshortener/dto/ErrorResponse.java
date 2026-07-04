package com.rishin.urlshortener.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private LocalDateTime timeStamp;
    private HttpStatus status;
    private String error;
    private String message;

    public ErrorResponse(HttpStatus status, String message) {
        this.timeStamp = LocalDateTime.now();
        this.status = status;
        this.error = status.getReasonPhrase();
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
