package ru.job4j.list;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс SimpleLinkedList.
 */
public class SimpleLinkedList<E> implements Iterable<E> {
    private int size = 0;

    public Node<E> getFirst() {
        return first;
    }

    public void setFirst(Node<E> first) {
        this.first = first;
    }

    private Node<E> first;
    private int modCount;

    /**
     * Метод добавляет данные value  в начало списка.
     *
     * @param value - данные.
     */
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        size++;
        modCount++;
    }

    /**
     * Метод получения элемента по индексу.
     *
     * @param index - индекс значения.
     * @return искомое значение.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            int count = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("В списке произошли изменения.");
                }
                return count < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Конец списка.");
                }
                Node<E> result;
                result = first;
                first = first.next;
                count++;
                return result.date;
            }
        };
    }

    /**
     * Класс предназначен для хранения данных.
     */
    static class Node<E> {
        final E date;
        Node<E> next;

        public Node(E date) {
            this.date = date;
        }
    }
}
