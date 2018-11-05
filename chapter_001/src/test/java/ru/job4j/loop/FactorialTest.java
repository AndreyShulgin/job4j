package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест сумма всех четнчх чисел заданного диапозона.
 * @author Andrey Shulgin (neonod404@gmail.com).
 */
public class FactorialTest {

    @Test
    public void whenFactorialThenN() {
        Factorial fact = new Factorial();
        int result = fact.calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void whenNThenNull() {
        Factorial fact = new Factorial();
        int result = fact.calc(0);
        assertThat(result, is(1));
    }
}