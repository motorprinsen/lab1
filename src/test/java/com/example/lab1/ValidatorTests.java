package com.example.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTests {

    @Test
    @DisplayName("Should not validate phone numbers not starting with '0'")
    void givenNotStartingWithZero_whenCheckingIsPhoneNumberValid_thenFalse() {
        var validator = new Validator();
        var result = validator.isPhoneNumberValid("123456789");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should validate phone numbers starting with '0'")
    void givenStartingWithZero_whenCheckingIsPhoneNumberValid_thenTrue() {
        var validator = new Validator();
        var result = validator.isPhoneNumberValid("0123456789");

        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Should not validate phone numbers with less than six digits")
    void givenFiveDigitNumber_whenCheckingIsPhoneNumberValid_thenFalse() {
        var validator = new Validator();
        var result = validator.isPhoneNumberValid("01234");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should not validate phone numbers with more than ten digits")
    void givenElevenDigitNumber_whenCheckingIsPhoneNumberValid_thenFalse() {
        var validator = new Validator();
        var result = validator.isPhoneNumberValid("01234567890");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should not validate phone numbers containing non-numeric characters")
    void givenNonNumericString_whenCheckingIsPhoneNumberValid_thenFalse() {
        var validator = new Validator();
        var result = validator.isPhoneNumberValid("0123456a");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should not validate address without @")
    void givenNoAtSign_whenCheckingIsEmailValid_thenFalse() {
        var validator = new Validator();
        var result = validator.isEmailValid("testexample.com");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should not validate address without top level domain")
    void givenNoTopLevelDomain_whenCheckingIsEmailValid_thenFalse() {
        var validator = new Validator();
        var result = validator.isEmailValid("test@example.");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should not validate address without domain name")
    void givenNoDomainName_whenCheckingIsEmailValid_thenFalse() {
        var validator = new Validator();
        var result = validator.isEmailValid("test@.com");

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should validate valid email address")
    void givenValidAddress_whenCheckingIsEmailValid_thenTrue() {
        var validator = new Validator();
        var result = validator.isEmailValid("test.user@example.com");
        result &= validator.isEmailValid("testuser@example.com");

        Assertions.assertTrue(result);
    }
}
