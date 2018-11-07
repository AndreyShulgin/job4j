package ru.job4j.array;

/**BubbleSort.
 * @author Andrey Shulgin (neonod404@gmail.com).
 */
public class BubbleSort {

    /**
     * Метод сортирует массив по возрастанию.
     * @param array массив.
     * @return возвращает массив по возрастанию.
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int mem = array [j];
                    array[j] = array [i];
                    array[i] = mem;
                }
            }
        }
        return array;
    }
}