package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleList<E> implements Iterable<E> {
    private Object[] list;
    private int index;
    private int modCount;

    public SimpleList(int size) {
        this.list = new Object[size];
    }

    public void add(E value) {
        Object[] newList;
        if (index == list.length) {
            newList = new Object[list.length * 2];
            System.arraycopy(list, 0, newList, 0, list.length);
            list = newList;
            modCount++;
        }
        list[index++] = value;
    }

    public E get(int position) {
        return (E) this.list[position];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
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
                return (E) list[indexIterator++];
            }
        };
    }
}
