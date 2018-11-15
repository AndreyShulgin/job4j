package ru.job4j.array;

/**TwoArrays.
 * @author Andrey Shulgin (neonod404@gmail.com).
 *
 */
public class TwoArrays {
    /**
     * Метод из двух массивов делает один отсортированный массив.
     * @param a - первый массив.
     * @param b - второй массив.
     * @return - отсортированный по возрастанию массив.
     */
    public int[] sortArrayOfTwoArrays(int[] a, int[] b) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] first = bubbleSort.sort(a);
        int[] second = bubbleSort.sort(b);
        int[] arrays = new int[first.length + second.length];
        int countA = 0;
        int countB = 0;
        for (int index = 0; index < arrays.length; index++) {
            if (first[countA] < second[countB]) {
                arrays[index] = first[countA];
                countA++;
                if (countA == first.length) {
                    countA--;
                    first[countA] += second[countB];
                }
            } else {
                arrays[index] = second[countB];
                countB++;
                if (countB == second.length) {
                    countB--;
                    second[countB] += first[countA];
                }
            }
        }

        return arrays;
    }
}