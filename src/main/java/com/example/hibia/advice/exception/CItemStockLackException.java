package com.example.hibia.advice.exception;

public class CItemStockLackException extends RuntimeException{
    public CItemStockLackException() {
        super();
    }

    public CItemStockLackException(String message) {
        super(message);
    }

    public CItemStockLackException(String message, Throwable cause) {
        super(message, cause);
    }
}
