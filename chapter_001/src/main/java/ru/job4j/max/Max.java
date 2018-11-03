package ru.job4j.max;

/**Максимум из двух чисел.
 * @author Andrey Shulgin (neonod404@gmail.com).
 */
public class Max {

    /**
     * Вычисляем максимальное из двух чисел.
     * @param first - первое число.
     * @param second -второе число.
     * @return - возвращает максимумальное число.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}