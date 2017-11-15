package com.company.tpIntegrador.exceptions;

public class CanjeableExistenteException extends RuntimeException {
    public CanjeableExistenteException(String message) {
        super(message);
    }

    public CanjeableExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
