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
        List<Integer> coins = new ArrayList<>();
        int count = 0;
        int delivery = value - price;
        while (delivery >= 10) {
            coins.add(count++, 10);
            delivery -= 10;
        }
        while (delivery >= 5) {
            coins.add(count++, 5);
            delivery -= 5;
        }
        while (delivery >= 2) {
            coins.add(count++, 2);
            delivery -= 2;
        }
        while (delivery >= 1) {
            coins.add(count++, 1);
            delivery -= 1;
        }
        count = 0;
        int[] result = new int[coins.size()];
        for (Integer x : coins) {
            result[count++] = x;
        }
        return result;
    }
}
