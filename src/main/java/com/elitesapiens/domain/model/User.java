package com.elitesapiens.domain.model;

import com.elitesapiens.domain.model.exceptions.AgeOutOfRangeException;
import com.elitesapiens.domain.model.exceptions.NameTooShortException;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private String name;
    private short age;

    private Cpf cpf;

    public User(String name, short age, Cpf cpf) {
        if (validateName(name)) {
            this.name = name;
        }
        if (validateAge(age)) {
            this.age = age;
        }

        this.cpf = cpf;
    }

    void setName(String name) {
        if (validateName(name)) {
            this.name = name;
        }
    }

    void setAge(short age) {
        if (validateAge(age)) {
            this.age = age;
        }
    }

    private boolean validateAge(short age) {
        if (age >= 0 && age < 100) {
            return true;
        }

        throw new AgeOutOfRangeException("Age is out of allowed range -> (0 >= age < 100)");
    }

    private boolean validateName(String name) {
        if (name.length() > 1) {
            return true;
        }

        throw new NameTooShortException("Name must be at least 2 characters.");

    }
}
