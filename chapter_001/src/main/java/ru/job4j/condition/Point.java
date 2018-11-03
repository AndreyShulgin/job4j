package  ru.job4j.condition;

/**Point.
 * @author Andrey Shulgin (neonod404@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Point {
    private int x;
    private int y;

    /**
     * Конструктор класса Point.
     * @param x - 1-ая координата точки.
     * @param y - 2-ая координата точки.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Вычисление расстояния между двумя точками.
     * @param that координата точки.
     * @return расстояние между точками.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));

    }

    /**
     * Main.
     * @param args - args.
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
         double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }

}