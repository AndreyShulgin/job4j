package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public double rubleToEuro(double value) {
        return value / 74.99;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары.
     */
    public double rubleToDollar(double value) {
        return value / 65.58;
    }

    /**
     * Конвертируем евру в рубли.
     * @param value евро.
     * @return Рубли.
     */
    public double euroToRuble(double value) {
        return value * 74.99;
    }

    /**
     * Ковентируем евро в доллары.
     * @param value евро.
     * @return Доллары.
     */
    public double euroToDollar(double value) {
        return value * 1.14;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли.
     */
    public double dollarToRuble(double value) {
        return value * 65.58;
    }

    /**
     * Ковенртируем доллары в евро.
     * @param value доллары.
     * @return Евро.
     */
    public double dollarToEuro(double value) {
        return value / 1.14;
    }
}