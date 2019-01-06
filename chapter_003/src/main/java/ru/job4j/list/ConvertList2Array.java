package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells;
        if (list.size() % rows != 0) {
            cells = list.size() / rows + 1;
        } else {
            cells = list.size() / rows;
        }
        int[][] array = new int[rows][cells];
        int listIndex = 0;
        for (int[] rowsIndex : array) {
            for (int cellsIndex = 0; cellsIndex < cells; cellsIndex++) {
                if (listIndex < list.size()) {
                    rowsIndex[cellsIndex] = list.get(listIndex++);
                }
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> array = new ArrayList<>();
        for (int[] listIndex : list) {
            for (Integer integer : listIndex) {
                array.add(integer);
            }
        }
        return array;
    }
}