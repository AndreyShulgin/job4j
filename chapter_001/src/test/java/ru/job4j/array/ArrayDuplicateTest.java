package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

    public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] newInput = array.remove(input);
        String[] expect = {"Привет", "Мир", "Супер"};
        assertThat(newInput, arrayContainingInAnyOrder(expect));
    }

    @Test
        public void whenRemoveDuplicatesThenWithoutDuplicateNumbers() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] input = {"1", "1", "2", "2", "1", "3", "3"};
        String[] result = array.remove(input);
        String[] expect = {"1", "2", "3"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}