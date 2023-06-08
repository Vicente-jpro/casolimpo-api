package com.casolimpo.api.exceptions;

public class ProvinciaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ProvinciaException(String errorMessage) {
        super(errorMessage);
    }
}
