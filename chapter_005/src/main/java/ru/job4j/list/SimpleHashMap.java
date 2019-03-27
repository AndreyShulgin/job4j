package ru.job4j.list;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<K> {

    private SimpleHashMap[] simpleMap;
    private K keySHM;
    private V valueSHM;
    private int index = 0;
    private int modCount = 0;

    private SimpleHashMap(K keySHM, V valueSHM) {
        this.keySHM = keySHM;
        this.valueSHM = valueSHM;
    }

    public SimpleHashMap(int size) {
        this.simpleMap = new SimpleHashMap[size];
    }

    public boolean insert(K key, V value) {
        SimpleHashMap<K, V> add = new SimpleHashMap<>(key, value);
        boolean result = true;
        SimpleHashMap[] shm;
        if (index == simpleMap.length) {
            shm = new SimpleHashMap[simpleMap.length * 2];
            System.arraycopy(simpleMap, 0, shm, 0, simpleMap.length);
            simpleMap = shm;
        }
        for (int position = 0; position != simpleMap.length; position++) {
            if (simpleMap[position] == null) {
                simpleMap[position] = add;
                break;
            }
            if (simpleMap[position].keySHM.hashCode() == key.hashCode()) {
                result = false;
                break;
            }
            if (simpleMap[position].keySHM == keySHM) {
                simpleMap[position] = add;
                break;
            }
        }
        if (result) {
            simpleMap[index++] = add;
            modCount++;
        }

        return result;
    }

    public V get(K key) {
        V result = null;
        for (int position = 0; position != simpleMap.length; position++) {
            if (simpleMap[position].keySHM.hashCode() == key.hashCode()) {
                result = (V) simpleMap[position].valueSHM;
            }
        }
        return result;
    }

    public boolean delete(K key) {
        boolean result = false;

        for (int position = 0; position != simpleMap.length; position++) {
            if (simpleMap[position].keySHM == key) {
                result = true;
                modCount++;
                for (int x = position; x != simpleMap.length - 1; x++) {
                    simpleMap[position] = simpleMap[position + 1];
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleHashMap<?, ?> that = (SimpleHashMap<?, ?>) o;
        return index == that.index
                && modCount == that.modCount
                && Arrays.equals(simpleMap, that.simpleMap)
                && Objects.equals(keySHM, that.keySHM)
                && Objects.equals(valueSHM, that.valueSHM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keySHM, valueSHM);
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < simpleMap.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (K) simpleMap[index].keySHM;
            }
        };
    }
}
