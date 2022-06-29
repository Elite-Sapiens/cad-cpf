package com.elitesapiens.domain.model.exceptions;

public class NameTooShortException extends RuntimeException{

    public NameTooShortException(String message) {
        super(message);
    }
}
