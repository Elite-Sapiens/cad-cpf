package com.elitesapiens.domain.model;

import com.elitesapiens.domain.model.exceptions.CpfInvalidException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CpfTest {

    @Test
    void testCpfWithDotsAndDashs() {
        Assertions.assertDoesNotThrow(() -> {
            new Cpf("123.123.123-12");
        });
    }

    @Test
    void testCpfWithoutDotsAndDashes() {
        Assertions.assertDoesNotThrow(() -> {
            new Cpf("12312312312");
        });
    }

    @Test
    void testCpfWithNumbersAndLetters() {
        Assertions.assertThrows(CpfInvalidException.class,
                () -> new Cpf("123abc123ab"));
    }

    @Test
    void testCpfWithOnlyLetters() {
        Assertions.assertThrows(CpfInvalidException.class,
                () -> new Cpf("abcabcabcab"));
    }

    @Test
    void testCpfWithOnlyDashes() {
        Assertions.assertThrows(CpfInvalidException.class,
                () -> new Cpf("----"));
    }

    @Test
    void testCpfWithOnlyDots() {
        Assertions.assertThrows(CpfInvalidException.class,
                () -> new Cpf("...."));
    }

    @Test
    void testCpfWithMoreThan11Digits() {
        Assertions.assertThrows(CpfInvalidException.class,
                () -> new Cpf("123123123123"));
    }

    @Test
    void testCpfWithLessThan11Digits() {
        Assertions.assertThrows(CpfInvalidException.class,
                () -> new Cpf("12312312"));
    }

    @Test
    void testCpfWithExactly11Digits() {
        Assertions.assertDoesNotThrow(() -> {
            new Cpf("12312312312");
        });
    }
}