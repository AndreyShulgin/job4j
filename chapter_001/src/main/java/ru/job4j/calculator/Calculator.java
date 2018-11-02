package ru.job4j.calculator;

/**Calculator.
 *
 * @author Andrey Shulgin (neonod404@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
    private double result;

    /**Add.
     *
     * @param first - 1-ое число.
     * @param second - 2-ое число.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**Subtract.
     *
     * @param first 1-ое число.
     * @param second 2-ое число.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /** Div.
     *
     * @param first 1-ое число.
     * @param second 2-ое число.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /** Multiple.
     *
     * @param first 1-ое число.
     * @param second 2-ое число.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /** GetResult.
     *
     * @return - возвращает результат.
     */
    public double getResult() {
        return this.result;
    }
}