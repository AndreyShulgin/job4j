package ru.job4j.coffee;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CoffeeTest {

    @Test
    public void whenCoffeeMachineReturnCoins() {
        Coffee coffee = new Coffee();
        int[] rst = coffee.changes(50, 31);
        int[] expect = {10, 5, 2, 2};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenCoffeeMachineReturnCoins2() {
        Coffee coffee = new Coffee();
        int[] rst = coffee.changes(60, 48);
        int[] expect = {10, 2};
        assertThat(rst, is(expect));
    }
}
