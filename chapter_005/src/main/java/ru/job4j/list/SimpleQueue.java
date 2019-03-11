package ru.job4j.list;


/**
 * Класс SimpleQueue.
 */
public class SimpleQueue<T> {
    private SimpleStack<T> in = new SimpleStack<>();
    private SimpleStack<T> out = new SimpleStack<>();

    /**
     * Метод удаляет первый внесенный элемент из списка.
     *
     * @return возвращает удаленный элемент.
     */
    public T poll() {
        while (!in.isEmpty()) {
            out.push(in.poll());
        }
        return out.poll();
    }

    /**
     * Метод помещает зачение в коллекцию.
     *
     * @param value - значение.
     */
    public void push(T value) {
        in.push(value);
    }

}

