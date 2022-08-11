package com.example.hibia.advice.exception;

public class CCartItemExistException extends RuntimeException {
    public CCartItemExistException() {
        super();
    }

    public CCartItemExistException(String message) {
        super(message);
    }

    public CCartItemExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
