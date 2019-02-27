package ru.job4.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;
    private int indexIterator = 0;


    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        objects[index++] = model;
    }

    public T get(int position) {
        return (T) this.objects[position];
    }

    public void set(int position, T model) {
        objects[position] = model;
    }

    public void remove(int position) {
        if (objects.length - 1 - position >= 0) {
            System.arraycopy(objects, position + 1, objects, position, objects.length - 1 - position);
        }
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                return indexIterator < objects.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Конец массива");
                }
                return (T) objects[indexIterator++];
            }
        };
    }
}
