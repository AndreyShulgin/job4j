package ru.job4j.loop;

/**Сумма всех четных чисел аданного диапозона.
 * @author Andrey Shulgin (neonod404@gmail.com).
 */
public class Counter {
    /**
     * Сумма всех четных чисел в диапозоне Start Finish.
     * @param start - начальное число.
     * @param finish - конечное число.
     * @return - сумма всех чисел в диапозоне Start Finish.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}