package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для конвертора.
 */

public class ConverterTest {
    /**
     * Ковертируем рубли в доллары.
     */
    @Test
    public void when65RubleToDollarThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToDollar(65.58);
        assertThat(result, is(1.0));
    }

    /**
     * Ковертируем рубли в евро.
     */
    @Test
    public void when75RubleToEuroThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToEuro(74.99);
        assertThat(result, is(1.0));
    }

    /**
     * Ковертируем евро в рубли.
     */
    @Test
    public void when1EuroToRubleThen75() {
        Converter converter = new Converter();
        double result = converter.euroToRuble(1);
        assertThat(result, is(74.99));
    }

    /**
     * Ковертируем евро в доллары.
     */
    @Test
    public void when1EuroTODollarThen1() {
        Converter converter = new Converter();
        double result = converter.euroToDollar(1);
        assertThat(result, is(1.14));
    }

    /**
     * Конвертируем доллары в рубли.
     */
    @Test
    public void when1DollarToRubleThen65() {
        Converter converter = new Converter();
        double result = converter.dollarToRuble(1);
        assertThat(result, is(65.58));
    }

    /**
     * Конвертируем доллары в евро.
     */
    @Test
    public void when1DollarToEuroThen1() {
        Converter converter = new Converter();
        double result = converter.dollarToEuro(1.14);
        assertThat(result, is(1.0));
    }
}