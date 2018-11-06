package ru.job4j.array;

/**Turn.
 * @author Andrey Shulgin (neonod404@gmail.com).
 */
public class Turn {

    /**Меняет порядок чисел в массиве задом на перед.
     *
     * @param array массив.
     * @return массив счислами задом на перед.
     */
    public int[] back(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int oldIndex = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = oldIndex;
        }
        return array;
    }
}