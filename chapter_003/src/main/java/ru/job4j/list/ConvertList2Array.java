package ru.job4j.list;

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
        for (int rowsIndex = 0; rowsIndex < rows; rowsIndex++) {
            for (int cellsIndex = 0; cellsIndex < cells; cellsIndex++) {
                if (listIndex < list.size()) {
                    array[rowsIndex][cellsIndex] = list.get(listIndex++);
                } else {
                    array[rowsIndex][cellsIndex] = 0;
                }
            }
        }
        return array;
    }
}