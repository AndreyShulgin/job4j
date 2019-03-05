package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenCreateArrayStringType() {
        SimpleArray<String> list = new SimpleArray<>(2);

        list.add("name");
        String result = list.get(0);

        assertThat(result, is("name"));
    }

    @Test
    public void whenCreateArrayIntegerType() {
        SimpleArray<Integer> list = new SimpleArray<>(2);

        list.add(5);
        int result = list.get(0);

        assertThat(result, is(5));
    }

    @Test
    public void whenRemoveItem() {
        SimpleArray<String> list = new SimpleArray<>(2);

        list.add("name");
        list.add("City");
        list.remove(0);
        String result = list.get(0);

        assertThat(result, is("City"));
    }

    @Test
    public void hasNext() {
        SimpleArray<String> list = new SimpleArray<>(4);
        Iterator<String> it = list.iterator();
        list.add("name");
        list.add("City");
        list.add("Address");
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("name"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("City"));
        assertThat(it.next(), is("Address"));
        assertThat(it.hasNext(), is(false));

    }

}