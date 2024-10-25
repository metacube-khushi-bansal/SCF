package test.java;

import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import Main.java.MathOperations;

public class lcmTest {

    public static Stream<Arguments> test1() {
        return Stream.of(
                Arguments.of(20, 30, 60),
                Arguments.of(10, 0, 0),
                Arguments.of(1, 34, 34));
    }

    @ParameterizedTest
    @MethodSource
    public void test1(int num1, int num2, int expected) {
        MathOperations mathOperations = new MathOperations();
        int result = mathOperations.calculateLCMOfTwoNumbers(num1, num2);
        Assert.assertEquals(result, expected);
    }

    public static Stream<Arguments> test2() {
        return Stream.of(
                Arguments.of(1, 45, 1),
                Arguments.of(10, 0, 10),
                Arguments.of(11, 12, 21));
    }

    @ParameterizedTest
    @MethodSource
    public void test2(int num1, int num2, int expected) {
        MathOperations mathOperations = new MathOperations();
        int result = mathOperations.calculateLCMOfTwoNumbers(num1, num2);
        Assert.assertFalse(result == expected);
    }
}
