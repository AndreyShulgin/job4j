package ru.job4j.loop;

/**Факториал чисел N.
 * @author Andrey Shulgin (neonod404@gmail.com).
 */
public class Factorial {
    /**Факториал чисел N.
     *
     * @param n целое число.
     * @return факториал числа N.
     */
    public int calc(int n) {
        int sum = 1;
        if (n != 0) {
            for (int i = n; i > 0; i--) {
                sum = sum * i;
            }
        }
        return sum;
    }
}