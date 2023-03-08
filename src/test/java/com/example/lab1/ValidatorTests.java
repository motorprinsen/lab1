package com.example.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Lab1Application.class)
public class ValidatorTests {

    @Test
    @DisplayName("Should not validate an empty phone number")
    void givenEmptyString_whenCheckingIsPhoneNumberValid_thenFalse() {
        var result = Validator.isPhoneNumberValid("");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should throw when phone number is null")
    void givenNull_whenCheckingIsPhoneNumberValid_thenFalse() {
        // TODO: Fix bug in Validator impl.
        Assertions.assertThrows(NullPointerException.class, () -> Validator.isPhoneNumberValid(null));
    }

    @Test
    @DisplayName("Should not validate phone number not starting with '0'")
    void givenNotStartingWithZero_whenCheckingIsPhoneNumberValid_thenFalse() {
        var result = Validator.isPhoneNumberValid("123456789");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should not validate phone number with less than six digits")
    void givenFiveDigitNumber_whenCheckingIsPhoneNumberValid_thenFalse() {
        var result = Validator.isPhoneNumberValid("01234");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should validate phone number with six digits")
    void givenSixDigitNumber_whenCheckingIsPhoneNumberValid_thenTrue() {
        var result = Validator.isPhoneNumberValid("012345");

        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Should not validate phone number with more than ten digits")
    void givenElevenDigitNumber_whenCheckingIsPhoneNumberValid_thenFalse() {
        var result = Validator.isPhoneNumberValid("01234567890");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should validate phone number with ten digits")
    void givenTenDigitNumber_whenCheckingIsPhoneNumberValid_thenTrue() {
        var result = Validator.isPhoneNumberValid("0123456789");

        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Should not validate phone number of correct length but containing non-numeric characters")
    void givenNonNumericString_whenCheckingIsPhoneNumberValid_thenFalse() {
        var result = Validator.isPhoneNumberValid("0123456a");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should validate phone number of correct length and starting with '0'")
    void givenValidNumber_whenCheckingIsPhoneNumberValid_thenTrue() {
        var result = Validator.isPhoneNumberValid("0123456789");

        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Should not validate address without @")
    void givenNoAtSign_whenCheckingIsEmailValid_thenFalse() {
        var result = Validator.isEmailValid("usernamedomain.com");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should not validate address without @, domain and top level domain")
    void givenNoAtSignNoDomainAndNoTopLevelDomain_whenCheckingIsEmailValid_thenFalse() {
        var result = Validator.isEmailValid("username");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should throw if username contains a period but no top level domain is provided")
    void givenUsernameWithPeriodAndNoTopLevelDomain_whenCheckingIsEmailValid_thenThrow() {
        // TODO: Fix bug in Validator impl.
        Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> Validator.isEmailValid("user.name@domain"));
    }

    @Test
    @DisplayName("Should not validate address without username")
    void givenNoUsername_whenCheckingIsEmailValid_thenFalse() {
        var result = Validator.isEmailValid("@domain.com");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should not validate address without domain name")
    void givenNoDomainName_whenCheckingIsEmailValid_thenFalse() {
        var result = Validator.isEmailValid("username@.com");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should not validate address without top level domain")
    void givenNoTopLevelDomain_whenCheckingIsEmailValid_thenFalse() {
        var result = Validator.isEmailValid("username@domain");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should validate valid email address")
    void givenValidAddress_whenCheckingIsEmailValid_thenTrue() {
        var result = Validator.isEmailValid("username@domain.com");

        Assertions.assertTrue(result);
    }
}
