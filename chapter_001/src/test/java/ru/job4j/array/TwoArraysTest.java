package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TwoArraysTest {
    @Test
    public void whenSortTwoArraysByTrueThenTrue() {
        TwoArrays twoArrays = new TwoArrays();
        int[] first = {1, 3, 4};
        int[] second = {2, 5, 6};
        int[] result = twoArrays.sortArrayOfTwoArrays(first, second);
        int[] expect = {1, 2, 3, 4, 5, 6};
        assertThat(result, is(expect));
    }
    @Test
    public void whenSortArraysByTrueThenTrue() {
        TwoArrays twoArrays = new TwoArrays();
        int[] first = {1, 3, 4, 5};
        int[] second = {2, 6};
        int[] result = twoArrays.sortArrayOfTwoArrays(first, second);
        int[] expect = {1, 2, 3, 4, 5, 6};
        assertThat(result, is(expect));
    }
}