package com.sahaj.hms.exception;

/**
 * Base exception class for Hotel Equipment Controller
 */
public class HmsBaseException extends Exception {
    public HmsBaseException(String message) {
        super(message);
    }

    public HmsBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
