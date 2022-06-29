package com.elitesapiens;

import com.elitesapiens.domain.model.Cpf;
import com.elitesapiens.domain.model.User;

public class Main {

    public static void main(String[] args) {
        User user = null;

        try {
            user = new User("John", (short) 23, new Cpf("12312312312"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (user != null) {
            System.out.println(user);
        }

    }
}