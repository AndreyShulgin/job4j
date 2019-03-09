package ru.job4j.list;

/**
 * Класс SimpleStack.
 */
public class SimpleStack<T> extends SimpleLinkedList<T> {

    /**
     * Метод удаляет значение и возвращает его.
     *
     * @return - удаленное значение.
     */
    public T poll() {
        Node<T> result = this.getFirst();
        this.setFirst(this.getFirst().next);
        return result.date;
    }


    /**
     * Метод помещает зачение в коллекцию.
     *
     * @param value - значение.
     */
    public void push(T value) {
        this.add(value);
    }
}