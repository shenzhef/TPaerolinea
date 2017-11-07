package com.company.tpIntegrador.exceptions;

public class UsuarioExistenteException extends RuntimeException {
    public UsuarioExistenteException(String message) {
        super(message);
    }

    public UsuarioExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
