package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Container<E> implements Iterable<E> {
    private Object[] container;
    private int index;
    private int modCount;

    public Container(int size) {
        this.container = new Object[size];
    }

    public void add(E value) {
        Object[] newContainer;
        if (index == container.length) {
            newContainer = new Object[container.length * 2];
            System.arraycopy(container, 0, newContainer, 0, container.length);
            container = newContainer;
            modCount++;
        }
        container[index++] = value;
    }

    public E get(int position) {
        return (E) this.container[position];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int indexIterator = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Длинна массива изменена.");
                }
                return indexIterator < index;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Конец массива.");
                }
                return (E) container[indexIterator++];
            }
        };
    }
}
