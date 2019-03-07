package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleLinkedListTest {
    private SimpleLinkedList<String> list;

    @Before
    public void createList() {
        list = new SimpleLinkedList<>();
        list.add("name");
        list.add("address");
        list.add("city");
    }

    @Test
    public void whenGetOneResultAddress() {
        assertThat(list.get(1), is("address"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUseIterator() {
        Iterator<String> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("city"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("address"));
        assertThat(it.next(), is("name"));
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenChangeListSizeThenIteratorException() {
        Iterator<String> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("city"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("address"));
        list.add("changer size");
        it.next();
    }
}