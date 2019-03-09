package ru.job4j.list;

/**
 * Класс SimpleStack.
 */
public class SimpleStack<T> {

    private SimpleLinkedList<T> list = new SimpleLinkedList<>();

    public SimpleLinkedList<T> getList() {
        return list;
    }

    public void setList(SimpleLinkedList<T> list) {
        this.list = list;
    }

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
}