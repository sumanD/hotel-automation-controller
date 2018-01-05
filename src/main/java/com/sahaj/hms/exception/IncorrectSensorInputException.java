package com.sahaj.hms.exception;

/**
 * This exception is to be used if the Sensor Input format is not
 * as expected
 */
public class IncorrectSensorInputException extends HmsBaseException {
    public IncorrectSensorInputException(String message) {
        super(message);
    }

    public IncorrectSensorInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
