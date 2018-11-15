package ru.job4j.array;

/**FindLoop.
 * @author Andrey Shulgin (neonod404@gmail.com).
 */
public class FindLoop {
    /**
     * Поиск в массиве определенного числа.
     * @param data массив.
     * @param el число которое необоходимо найти.
     * @return индекс числа, или -1, если числа нет.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; 
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}