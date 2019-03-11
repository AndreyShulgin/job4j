package ru.job4j.list;

/**
 * Класс Node.
 */
public class Node<T> {
    private T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    /**
     * Метод проверяет цилличность связанного списка.
     *
     * @return возврящает True если связанный списокявляется циклическим.
     */
    public boolean hasCycle(Node first) {
        boolean result = false;
        Node one = first;
        Node two = first;
        while (one != null && one.next != null) {
            two = two.next;
            one = one.next.next;
            if (one == two) {
                result = true;
                break;
            }
        }
        return result;
    }
}
