package ru.job4j.list;

/**
 * Класс SimpleQueue.
 */
public class SimpleQueue<T> {
    private SimpleStack<T> stack = new SimpleStack<>();
    private SimpleStack<T> newStack = new SimpleStack<>();

    public SimpleStack<T> getStack() {
        return stack;
    }

    /**
     * Метод удаляет первый внесенный элемент из списка.
     *
     * @return возвращает удаленный элемент.
     */
    public T poll() {
        T result;
        int size = stack.getList().getSize();
        for (T element : stack.getList()) {
            newStack.getList().add(element);
        }
        result = newStack.getList().removeFirst();
        for (T element : newStack.getList()) {
            stack.getList().add(element);
        }
        stack.getList().setSize(--size);
        return result;
    }

    /**
     * Метод помещает зачение в коллекцию.
     *
     * @param value - значение.
     */
    public void push(T value) {
        stack.getList().add(value);
    }
}

