package ru.job4j.coffee;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    /**
     *
     * @param value - купюра.
     * @param price - цена кофе.
     * @return массив из монет сдачи.
     */
    int[] changes(int value, int price) {
        List<Integer> list = new ArrayList<>();
        int delivery = value - price;
        int count = 0;
        int[] coins = {10, 5, 2, 1};
        for (int index = 0; index < coins.length;) {
            if (delivery >= coins[index]) {
                list.add(count++, coins[index]);
                delivery -= coins[index];
            } else {
                index++;
            }
        }
        count = 0;
        int[] result = new int[list.size()];
        for (Integer x : list) {
            result[count++] = x;
        }
        return result;
    }
}
