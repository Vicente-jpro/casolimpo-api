package com.casolimpo.api.exceptions;

public class EnderecoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EnderecoException(String errorMessage) {
        super(errorMessage);
    }
}
