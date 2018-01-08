package com.sahaj.hms.exception;

public class InvalidHotelInitRequestException extends HmsBaseException {

    public InvalidHotelInitRequestException(String message) {
        super(message);
    }

    public InvalidHotelInitRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
