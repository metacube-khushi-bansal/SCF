package test.java;

import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import Main.java.Search;

public class linearSearchTest {

    public static Stream<Arguments> test1() {
        return Stream.of(
                Arguments.of(new int[] { 4, 3, 2, 1 }, 3, 4, 1),
                Arguments.of(new int[] { 10, 20, 30, 15 }, 100, 4, -1),
                Arguments.of(new int[] { 45, 34, 12, 90 }, 45, 4, 0) );
    }

    @ParameterizedTest
    @MethodSource
    public void test1(int num[], int key, int length, int expected) {
        Search search = new Search();
        int result = search.linearSearch(num, key, length);
        Assert.assertEquals(result, expected);
    }

    public static Stream<Arguments> test2() {
        return Stream.of(
                Arguments.of(new int[] { 4, 3, 2, 1 }, 3, 4, 0),
                Arguments.of(new int[] { 10, 20, 30, 15 }, 100, 4, 1),
                Arguments.of(new int[] { 45, 34, 12, 90 }, 45, 4, 1));

    }

    @ParameterizedTest
    @MethodSource
    public void test2(int num[], int key, int length, int expected) {
        Search search = new Search();
        int result = search.linearSearch(num, key, length);
        Assert.assertEquals(result, expected);
    }
}
