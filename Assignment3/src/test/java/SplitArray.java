package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.*;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import Main.java.ArrOperations;

public class SplitArray {

    public static Stream<Arguments> test1() {
        return Stream.of(
                Arguments.of(new int[] { 1, 2, 1, 1, 1 }, 2),
                Arguments.of(new int[] { 2, 1, 1, 2, 1 }, -1),
                Arguments.of(new int[] { 10, 10 }, 1));
    }

    @ParameterizedTest
    @MethodSource()
    public void test1(int[] input, int expected) { // positive test case
        ArrOperations arrOperations = new ArrOperations();
        int result = arrOperations.splitArray(input);
        assertEquals(result, expected);
    }

    public static Stream<Arguments> test2() {
        return Stream.of(
                Arguments.of(new int[] { 1, 2, 3, 4 }, 3),
                Arguments.of(new int[] { 3, 3, 3, 3 }, 3),
                Arguments.of(new int[] { 1, 1, 1 }, 2));
    }

    @ParameterizedTest
    @MethodSource()
    public void test2(int[] input, int expected) { // negative test case
        ArrOperations arrOperations = new ArrOperations();
        int result = arrOperations.splitArray(input);
        Assert.assertFalse(result == expected);
    }

}
