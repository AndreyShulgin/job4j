package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = left.length() - right.length();
        int length = Math.min(left.length(), right.length());
        for (int index = 0; index < length; index++) {
            if (left.charAt(index) != right.charAt(index)) {
                result = left.charAt(index) - right.charAt(index);
                break;
            }
        }
        return result;
    }
}
