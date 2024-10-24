package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.*;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import Main.java.ArrOperations;

public class NoOfClumpsTest {

    public static Stream<Arguments> test1() {
        return Stream.of(
                Arguments.of(new int[] { 1, 1, 2, 1, 1 }, 2),
                Arguments.of(new int[] { 1, 1, 1, 1, 1 }, 1),
                Arguments.of(new int[] { 4, 4, 4, 2, 3, 5, 5, 6 }, 2));
    }

    @ParameterizedTest
    @MethodSource()
    public void test1(int[] input, int expected) { // positive test case
        ArrOperations arrOperations = new ArrOperations();
        int result = arrOperations.calculateNoOfClumps(input);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> test2() {
        return Stream.of(
                Arguments.of(new int[] { 1,2,3,4,5}, 3),
                Arguments.of(new int[] { 4,4,4,4,4 }, 5),
                Arguments.of(new int[] { 1 }, 2));
    }

    @ParameterizedTest
    @MethodSource()
    public void test2(int[] input, int expected) { // negative test case
        ArrOperations arrOperations = new ArrOperations();
        
        int result = arrOperations.calculateNoOfClumps(input) ;
        Assert.assertFalse(result == expected);
    }

}
