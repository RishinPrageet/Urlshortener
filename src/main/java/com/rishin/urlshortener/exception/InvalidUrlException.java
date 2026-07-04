package com.rishin.urlshortener.exception;

public class InvalidUrlException extends RuntimeException {

    public InvalidUrlException() {
    }

    public InvalidUrlException(String message) {
        super(message);
    }

    public InvalidUrlException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
