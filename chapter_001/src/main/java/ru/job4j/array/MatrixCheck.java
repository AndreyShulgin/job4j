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
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data [i + 1][i + 1] || data[i][data.length - 1 - i] != data[i + 1][data.length  - 2 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}