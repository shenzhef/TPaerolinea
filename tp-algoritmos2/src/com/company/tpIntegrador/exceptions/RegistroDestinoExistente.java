package com.company.tpIntegrador.exceptions;

public class RegistroDestinoExistente extends RuntimeException {
    public RegistroDestinoExistente(String message) {
        super(message);
    }

    public RegistroDestinoExistente(String message, Throwable cause) {
        super(message, cause);
    }
}

