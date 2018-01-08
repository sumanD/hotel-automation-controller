package com.sahaj.hms.exception;

/**
 * Validation Exception Class
 */
public class ValidationException extends HmsBaseException{
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
