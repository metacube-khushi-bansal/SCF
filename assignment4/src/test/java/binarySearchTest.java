package test.java;

import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import Main.java.Search;

public class binarySearchTest {

    public static Stream<Arguments> test1() {
        return Stream.of(
                Arguments.of(new int[] { 1, 2, 3, 4 }, 3, 0, 3, 2),
                Arguments.of(new int[] { 10, 20, 30, 40 }, 100, 0, 3, -1),
                Arguments.of(new int[] { 11, 30, 56, 89 }, 30, 0, 3, 1));
    }

    @ParameterizedTest
    @MethodSource
    public void test1(int num[], int key, int lo, int hi, int expected) {
        Search search = new Search();
        int result = search.binarySearch(num, key, lo, hi);
        Assert.assertEquals(result, expected);
    }

    public static Stream<Arguments> test2() {
        return Stream.of(
                Arguments.of(new int[] { 1, 2, 3, 4 }, 3, 0, 3, 1),
                Arguments.of(new int[] { 10, 20, 30, 40 }, 100, 0, 3, 1),
                Arguments.of(new int[] { 11, 30, 56, 89 }, 30, 0, 3, 12));
    }

    @ParameterizedTest
    @MethodSource
    public void test2(int num[], int key, int lo, int hi, int expected) {
        Search search = new Search();
        int result = search.binarySearch(num, key, lo, hi);
        Assert.assertFalse(result== expected);
    }

}
