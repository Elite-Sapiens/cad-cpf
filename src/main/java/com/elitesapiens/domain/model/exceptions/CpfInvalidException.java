package com.elitesapiens.domain.model.exceptions;

public class CpfInvalidException extends RuntimeException{

    public CpfInvalidException(String message) {
        super(message);
    }
}
