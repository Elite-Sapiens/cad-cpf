package com.elitesapiens.domain.model;

import com.elitesapiens.domain.model.exceptions.AgeOutOfRangeException;
import com.elitesapiens.domain.model.exceptions.CpfInvalidException;
import com.elitesapiens.domain.model.exceptions.NameTooShortException;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Data
class UserTest {


    @Test
    void testNameWithOneLetter() {
        Assertions.assertThrows(NameTooShortException.class,
                () -> new User("l", (short) 23, new Cpf("12312312312")));
    }

    @Test
    void testNameWithoutLetter() {
        Assertions.assertThrows(NameTooShortException.class,
                () -> new User("", (short) 23, new Cpf("12312312312")));
    }

    @Test
    void testAgeWithNegativeValue() {
        Assertions.assertThrows(AgeOutOfRangeException.class,
                () -> new User("John", (short) -23, new Cpf("12312312312")));
    }

    @Test
    void testAgeWithValueEqualTo100() {
        Assertions.assertThrows(AgeOutOfRangeException.class,
                () -> new User("John", (short) 100, new Cpf("12312312312")));
    }

    @Test
    void testAgeWithValueAbove100() {
        Assertions.assertThrows(AgeOutOfRangeException.class,
                () -> new User("John", (short) 101, new Cpf("12312312312")));
    }

    @Test
    void testCpfWithNumbersAndLetters() {
        Assertions.assertThrows(CpfInvalidException.class,
                () -> new User("John", (short) 23, new Cpf("123abc123ab")));
    }

    @Test
    void testCpfWithOnlyLetters() {
        Assertions.assertThrows(CpfInvalidException.class,
                () -> new User("John", (short) 23, new Cpf("abcabcabcab")));
    }

    @Test
    void testCpfWithLessThan11Digits() {
        Assertions.assertThrows(CpfInvalidException.class,
                () -> new User("John", (short) 23, new Cpf("123123123")));
    }

    @Test
    void testCpfWithMoreThan11Digits() {
        Assertions.assertThrows(CpfInvalidException.class,
                () -> new User("John", (short) 23, new Cpf("123123123123")));
    }

    @Test
    void testCpfWithExactly11Digits() {
        Assertions.assertDoesNotThrow(() -> {
            new User("John", (short) 23, new Cpf("12312312312"));
        });
    }

    @Test
    void testSetterNameWithMoreThanTwoLetters() {
        User user = new User("John", (short) 23, new Cpf("12312312312"));
        user.setName("Bai");
        Assertions.assertEquals("Bai", user.getName());
    }

    @Test
    void testSetterNameWithOneLetter() {
        User user = new User("John", (short) 23, new Cpf("12312312312"));
        Assertions.assertThrows(NameTooShortException.class, () -> user.setName("l"));
    }

    @Test
    void testSetterNameWithoutLetter() {
        User user = new User("John", (short) 23, new Cpf("12312312312"));
        Assertions.assertThrows(NameTooShortException.class, () -> user.setName(""));
    }

    @Test
    void testSetterAgeWithNegativeValue() {
        User user = new User("John", (short) 23, new Cpf("12312312312"));
        Assertions.assertThrows(AgeOutOfRangeException.class, () -> user.setAge((short) -23));
    }

    @Test
    void testSetterAgeWithValueEqualTo100() {
        User user = new User("John", (short) 23, new Cpf("12312312312"));
        Assertions.assertThrows(AgeOutOfRangeException.class, () -> user.setAge((short) 100));
    }

    @Test
    void testSetterAgeWithValueAbove100() {
        User user = new User("John", (short) 23, new Cpf("12312312312"));
        Assertions.assertThrows(AgeOutOfRangeException.class, () -> user.setAge((short) 101));
    }

    @Test
    void testSetterCpfWithNumbersAndLetters() {
        User user = new User("John", (short) 23, new Cpf("12312312312"));
        Assertions.assertThrows(CpfInvalidException.class,
                () -> user.setCpf(new Cpf("123abc123ab")));
    }

    @Test
    void testSetterCpfWithOnlyLetters() {
        User user = new User("John", (short) 23, new Cpf("12312312312"));
        Assertions.assertThrows(CpfInvalidException.class,
                () -> user.setCpf(new Cpf("abcabcabcab")));
    }

    @Test
    void testSetterCpfWithLessThan11Digits() {
        User user = new User("John", (short) 23, new Cpf("12312312312"));
        Assertions.assertThrows(CpfInvalidException.class,
                () -> user.setCpf(new Cpf("123123123")));
    }

    @Test
    void testSetterCpfWithMoreThan11Digits() {
        User user = new User("John", (short) 23, new Cpf("12312312312"));
        Assertions.assertThrows(CpfInvalidException.class,
                () -> user.setCpf(new Cpf("123123123123")));
    }

    @Test
    void testSetterCpfWithExactly11Digits() {
        User user = new User("John", (short) 23, new Cpf("12312312312"));
        Assertions.assertDoesNotThrow(() -> user.setCpf(new Cpf("999.888.777-66")));
    }

}