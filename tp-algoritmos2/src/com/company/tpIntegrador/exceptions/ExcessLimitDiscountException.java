package com.company.tpIntegrador.exceptions;

public class ExcessLimitDiscountException extends RuntimeException {
    public ExcessLimitDiscountException(String message) {
        super(message);
    }

    public ExcessLimitDiscountException(String message, Throwable cause) {
        super(message, cause);
    }
}
