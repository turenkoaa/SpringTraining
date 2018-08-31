package com.db.exceptions_handling;

public class DataBaseRuntimeException extends RuntimeException {
    private String message;

    public DataBaseRuntimeException(String message) {
        super(message);
        this.message = message;
    }
}
