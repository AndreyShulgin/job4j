package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**CalculatorTest.
 *
 * @author Andrey Shulgin (neonod404@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest {
    /**
     * Test Add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Test Subtract.
     */
    @Test
    public void whenSubtractOneMinusThenTwo() {
        Calculator calc = new Calculator();
        calc.subtract(2D, 1D);
        double result = calc.getResult();
        double expected = 1;
        assertThat(result, is(expected));
    }
    /**
     * Test Div.
     */
    @Test
    public void whenDivOneDivideThenWwo() {
        Calculator calc = new Calculator();
        calc.div(2D, 1D);
        double result = calc.getResult();
        double expected = 2;
        assertThat(result, is(expected));
    }
    /**
     * Test Multiple.
     */
    @Test
    public void whenMultipleOneMutiplyThenTwo() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 2D);
        double result = calc.getResult();
        double expected = 4;
        assertThat(result, is(expected));
    }
}