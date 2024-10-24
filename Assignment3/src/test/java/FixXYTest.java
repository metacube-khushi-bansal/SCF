package test.java;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.*;

import Main.java.ArrOperations;

public class FixXYTest {

     public static Stream<Arguments> test1() {
        return Stream.of(
                Arguments.of(new int[] { 5, 4, 9, 4, 9, 5 },4,5, new int[] {9, 4, 5, 4, 5, 9}),
                Arguments.of(new int[] {1, 4, 1, 5 },4,5, new int[] {1, 4, 5, 1}),
                Arguments.of(new int[] { 1, 4, 1, 5, 5, 4, 1 },4,5, new int[] {1, 4, 5, 1, 1, 4, 5}))
                ;
    }
    @ParameterizedTest
    @MethodSource()
    public void test1(int [] input, int X, int Y, int[]expected) { // positive test case
        ArrOperations arrOperations = new ArrOperations();

        int result[] = arrOperations.solveFixXYProblem(input,X,Y);
        Assert.assertArrayEquals(expected,result );
    }


    public static Stream<Arguments> test2() {
        return Stream.of(
                Arguments.of(new int[] { 5, 4, 9, 4, 9, 5 },4,5, new int[] {9, 9, 4, 5, 4, 5}),
                Arguments.of(new int[] {1, 4, 1, 5 },4,5, new int[] {1, 4, 1, 5}),
                Arguments.of(new int[] { 1, 4, 1, 5, 5, 4, 1 },4,5, new int[] { 4, 5,1, 1, 1, 4, 5}))
                ;
    }
    @ParameterizedTest
    @MethodSource()
    public void test2(int [] input, int X, int Y, int[]expected) { // negative test case
        ArrOperations arrOperations = new ArrOperations();
       
        int result [] =  arrOperations.solveFixXYProblem(input, X, Y);
        Assert.assertFalse(expected == result);
    }

   

}
