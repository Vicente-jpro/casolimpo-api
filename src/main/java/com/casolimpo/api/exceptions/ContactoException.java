package com.casolimpo.api.exceptions;

public class ContactoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ContactoException(String errorMessage) {
        super(errorMessage);
    }
}
