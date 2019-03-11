package ru.job4j.list;

/**
 * Класс SimpleStack.
 */
public class SimpleStack<T> {
    private SimpleLinkedList<T> list = new SimpleLinkedList<>();

    /**
     * Метод удаляет значение и возвращает его.
     *
     * @return - удаленное значение.
     */
    public T poll() {
        return list.removeFirst();
    }

    /**
     * Метод помещает зачение в коллекцию.
     *
     * @param value - значение.
     */
    public void push(T value) {
        list.add(value);
    }

    /** Метод проверяет наличие элементов в коллекции.
     * @return возвращет true или false.
     */
    public boolean isEmpty() {
        return list.getSize() == 0;
    }
}