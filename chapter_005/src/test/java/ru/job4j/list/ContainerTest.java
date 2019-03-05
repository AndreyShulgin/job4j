package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ContainerTest {

    @Test
    public void whenCreateArrayStringType() {
        Container<String> container = new Container<>(2);

        container.add("Hello");

        assertThat(container.get(0), is("Hello"));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenChangeArrayLengthThenCME() {
        Container<String> container = new Container<>(2);
        Iterator it = container.iterator();

        container.add("Hello");
        container.add("Hi");

        assertThat(it.hasNext(), is(true));

        container.add("new Size");
        it.next();
    }

}