package ru.job4j.array;

/**MatrixCheck.
 * @author Andrey Shulgin (neonod404@gmail.com).
 */
public class MatrixCheck {
    /**
     * Метод проверяет диагонали матрицы на одинаковые эллементы.
     * @param data метод.
     * @return True если все эллементы по диагонали одинаковые.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;

        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j < data.length; j++) {
                if (i == j && data[i][j] != data[i -1][j -1] || i == data.length - 1 - j && data[i][data.length - 1 - j] != data[i-1][data.length -2 -j]) {
                    result = false;
                }
            }
        }
        return result;
    }
}