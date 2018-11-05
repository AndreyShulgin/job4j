package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест сумма всех четнчх чисел заданного диапозона.
 * @author Andrey Shulgin (neonod404@gmail.com).
 */
public class CounterTest {

    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
       Counter counter = new Counter();
       int result = counter.add(1, 10);
       int expected = 30;
       assertThat(result, is(expected));
    }
}