package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator {
    final int[] numbers;
    private int[] evenNumbers;
    private int index = 0;
    private int count = 0;

    public EvenIt(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        if (count != 1) {
            evenNumbers = getEvenArray();
        }
        return evenNumbers.length > index;
    }

    @Override
    public Object next() {
        if (index == evenNumbers.length) {
            throw new NoSuchElementException();
        }
        if (count != 1) {
            evenNumbers = getEvenArray();
        }
        return evenNumbers[index++];
    }

    private int[] getEvenArray() {
        count = 1;
        return Arrays.stream(numbers).filter(numbers -> numbers % 2 == 0).toArray();
    }
}
