package ru.job4j.iterator;

import java.util.Iterator;

public class IteratorMatrix implements Iterator {
    private final int[][] values;
    private int secondIndex = 0;
    private int firstIndex = 0;

    public IteratorMatrix(final int[][] values) {
        this.values = values;
    }


    @Override
    public boolean hasNext() {
        boolean rst = true;
        if (secondIndex == values[firstIndex].length && firstIndex + 1 == values.length) {
            rst = false;
        }
            return rst;
    }

    @Override
    public Object next() {
        if (secondIndex == values[firstIndex].length) {
            firstIndex++;
            secondIndex = 0;
        }
        return values[firstIndex][secondIndex++];
    }
}
