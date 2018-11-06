package ru.job4j.array;

/**Square.
 * @author Andrey Shulgin (neonod404@gmail.com).
 */
public class Square {
    /**Метод заполянет массив квадратом чисел от 1 до Bound.
     *
     * @param bound - длинна массива.
     * @return заполненный массив.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int index = 0; index < bound; index++) {
           rst [index] = (index + 1) * (index + 1);
        }
        return rst;
    }
}