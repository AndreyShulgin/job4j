package ru.job4j.array;

/**TwoArrays.
 * @author Andrey Shulgin (neonod404@gmail.com).
 *
 */
public class TwoArrays {
    /**
     * Метод из двух массивов делает один отсортированный массив.
     * @param first - первый массив.
     * @param second - второй массив.
     * @return - отсортированный по возрастанию массив.
     */
    public int[] sortArrayOfTwoArrays(int[] first, int[] second) {
        int[] arrays = new int[first.length + second.length];
        int countFirst = 0;
        int countSecond = 0;
        int countArrays = 0;
        while (countFirst < first.length && countSecond < second.length) {
            if (first[countFirst] < second[countSecond]) {
                arrays[countArrays] = first[countFirst];
                countFirst++;
            } else {
                arrays[countArrays] = second[countSecond];
                countSecond++;
            }
            countArrays++;
        }
        while (countFirst < first.length) {
            arrays[countArrays] = first[countFirst];
            countArrays++;
            countFirst++;
        }
        while (countSecond < second.length) {
            arrays[countArrays] = second[countSecond];
            countArrays++;
            countSecond++;
        }
        return arrays;
    }
}