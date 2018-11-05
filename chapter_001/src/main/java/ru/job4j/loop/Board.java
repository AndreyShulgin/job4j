package ru.job4j.loop;

/**Шахматное поле.
 * @author Andrey Shulgin (neonod404@gmail.com).
 */
public class Board {
    /**
     * Шахматное поле шириной width и высотой height.
     * @param width ширина поля.
     * @param height высота поля.
     * @return ВОзвращает поле с заданными сторонами.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
