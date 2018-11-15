package ru.job4j.array;

/**TwoArrays.
 * @author Andrey Shulgin (neonod404@gmail.com).
 *
 */
public class TwoArrays {
    /**
     * Метод из двух массивов делает один отсортированный массив.
     * @param firstArray - первый массив.
     * @param secondArray - второй массив.
     * @return - отсортированный по возрастанию массив.
     */
    public int[] sortArrayOfTwoArrays(int[] firstArray, int[] secondArray) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] sortFirstArray = bubbleSort.sort(firstArray);
        int[] sortSecondArray = bubbleSort.sort(secondArray);
        int[] arrayOfThoArrays = new int[sortFirstArray.length + sortSecondArray.length];
        int countFirstArray = 0;
        int countSecondArray = 0;
        for (int index = 0; index < arrayOfThoArrays.length; index++) {
            if (sortFirstArray[countFirstArray] < sortSecondArray[countSecondArray]) {
                arrayOfThoArrays[index] = sortFirstArray[countFirstArray];
                countFirstArray++;
                if (countFirstArray == sortFirstArray.length) {
                    countFirstArray--;
                    sortFirstArray[countFirstArray] += sortSecondArray[countSecondArray];
                }
            } else {
                arrayOfThoArrays[index] = sortSecondArray[countSecondArray];
                countSecondArray++;
                if (countSecondArray == sortSecondArray.length) {
                    countSecondArray--;
                    sortSecondArray[countSecondArray] += sortFirstArray[countFirstArray];
                }
            }
        }

        return arrayOfThoArrays;
    }
}