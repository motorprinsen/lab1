package com.example.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    @Test
    @DisplayName("Should add 3 + 3 correctly")
    void givenThreeAndThree_whenAdd_thenSix() {
        var calculator = new Calculator();
        var result = calculator.add(3, 3);

        Assertions.assertEquals(6, result);
    }

    @Test
    @DisplayName("Should subtract 3 - 3 correctly")
    void givenThreeAndThree_whenSubtract_thenZero() {
        var calculator = new Calculator();
        var result = calculator.subtract(3, 3);

        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("Should multiply 3 x 3 correctly")
    void givenThreeAndThree_whenMultiply_thenNine() {
        var calculator = new Calculator();
        var result = calculator.multiply(3, 3);

        Assertions.assertEquals(9, result);
    }

    @Test
    @DisplayName("Should return positive number when multiplying two negative numbers")
    void givenMinusThreeAndMinusThree_whenMultiply_thenNine() {
        var calculator = new Calculator();
        var result = calculator.multiply(-3, -3);

        Assertions.assertTrue(result >= 0);
    }

    @Test()
    @DisplayName("Should return infinity when dividing with 0")
    void givenOneAndZero_whenDividing_thenInfinity() {
        var calculator = new Calculator();
        var result = calculator.divide(1, 0);

        Assertions.assertTrue(Double.isInfinite(result));
    }

    @Test
    @DisplayName("Should return NaN when getting square root of negative number")
    void givenNegativeNumber_whenSquareRootOf_thenNaN() {
        var calculator = new Calculator();
        var result = calculator.squareRootOf(-25);

        Assertions.assertTrue(Double.isNaN(result));
    }

    @Test
    @DisplayName("Should return the square root of 25")
    void givenTwentyFive_whenSquareRootOf_thenFive() {
        var calculator = new Calculator();
        var result = calculator.squareRootOf(25);

        Assertions.assertEquals(5, result);
    }

    @Test
    @DisplayName("Should return NaN when getting area if radius is less than 0")
    void givenMinusOne_whenGetArea_thenNaN() {
        var calculator = new Calculator();
        var result = calculator.getArea(-1);

        Assertions.assertTrue(Double.isNaN(result));
    }

    @Test
    @DisplayName("Should return 0 when getting area if radius is 0")
    void givenZero_whenGetArea_thenZero() {
        var calculator = new Calculator();
        var result = calculator.getArea(0);

        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return ≈π when getting area if radius is 1")
    void givenOne_whenGetArea_thenPi() {
        var calculator = new Calculator();
        var result = calculator.getArea(1);

        // getArea() rounds the result, so we must do the same
        var approximatelyPi = Math.round(Math.PI * 100.0) / 100.0;

        Assertions.assertEquals(approximatelyPi, result);
    }

    @Test
    @DisplayName("Should return NaN when getting circumference if radius is less than 0")
    void givenMinusOne_whenGetCircumference_thenNaN() {
        var calculator = new Calculator();
        var result = calculator.getCircumference(-1);

        Assertions.assertTrue(Double.isNaN(result));
    }

    @Test
    @DisplayName("Should return 0 when getting circumference if radius is 0")
    void givenZero_whenGetCircumference_thenNaN() {
        var calculator = new Calculator();
        var result = calculator.getCircumference(0);

        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return ≈2π when getting circumference if radius is 1")
    void givenOne_whenGetCircumference_thenTwoPi() {
        var calculator = new Calculator();
        var result = calculator.getCircumference(1);

        // getCircumference() rounds the result, so we must do the same
        var approximatelyTwoPi = Math.round(Math.PI * 2 * 100.0) / 100.0;

        Assertions.assertEquals(approximatelyTwoPi, result);
    }
}
