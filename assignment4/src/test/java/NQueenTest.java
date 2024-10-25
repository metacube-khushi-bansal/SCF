package test.java;

import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import Main.java.NQueenProblem;

public class NQueenTest {

    public static Stream<Arguments> test1() {
        return Stream.of(
                Arguments.of(4 ,true),
                Arguments.of(3 ,false));
                
    }

    @ParameterizedTest
    @MethodSource
    public void test1(int num,int expected) {
       NQueenProblem nQueenProblem = new NQueenProblem();
        boolean result = nQueenProblem.solveNQueen(0,num);
        Assert.assertEquals(result, expected);
    }

    public static Stream<Arguments> test2() {
        return Stream.of(
                Arguments.of(4 ,false),
                Arguments.of(3 ,true));
                
    }

    @ParameterizedTest
    @MethodSource
    public void test2(int num,boolean expected) {
      NQueenProblem nQueenProblem = new NQueenProblem();
        boolean result = nQueenProblem.solveNQueen(0,num);
        Assert.assertFalse(result == expected);
    }
}
