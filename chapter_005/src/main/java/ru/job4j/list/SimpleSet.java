package ru.job4j.list;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleList<E> simpleList = new SimpleList(10);

    public void add(E value) {
        boolean result = true;
        for (E list : simpleList) {
            if (list.equals(value)) {
                result = false;
                break;
            }
        }
        if (result) {
            simpleList.add(value);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return simpleList.iterator();
    }
}
