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
        if (!out.getList().iterator().hasNext()) {
            for (T t : in.getList()) {
                out.push(t);
            }
            in = null;
        }
        return out.poll();
    }

    /**
     * Метод помещает зачение в коллекцию.
     *
     * @param value - значение.
     */
    public void push(T value) {
        in.getList().add(value);
    }
}

