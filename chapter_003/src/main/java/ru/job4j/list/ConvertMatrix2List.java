package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        int size = array[0].length;
        for (int[] ints : array) {
            for (int in = 0; in < size; in++) {
                list.add(index++, ints[in]);
            }
        }
        return list;
    }
}