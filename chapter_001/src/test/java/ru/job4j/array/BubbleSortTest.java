package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {

    @Test
    public void whenBubbleSortByTrueThenTrue() {
        BubbleSort bubble = new BubbleSort();
        int[] input = new int[] {5, 1, 2, 7, 3, 8, 14, 21, 0};
        int[] result = bubble.sort(input);
        int[] expect = new int[] {0, 1, 2, 3, 5, 7, 8, 14, 21};
        assertThat(result, is(expect));
    }
}