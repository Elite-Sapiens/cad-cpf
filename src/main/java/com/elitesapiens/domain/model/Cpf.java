package com.elitesapiens.domain.model;

import com.elitesapiens.domain.model.exceptions.CpfInvalidException;
import lombok.Data;

@Data
public class Cpf {

    private String number;

    public Cpf(String number) {
        if (validateCpf(number)) {
            this.number = number;
        }
    }

    private boolean validateCpf(String number) {
        var regex = "(^(\\d{3}\\.?){3}-?\\d{2}$)";

        if (number.matches(regex)) {
            return true;
        }

        throw new CpfInvalidException("CPF must have 11 digit characters");
    }
}
