package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    private SimpleStack<String> stack;

    @Before
    public void createSimpleStack() {
        stack = new SimpleStack<>();
        stack.push("name");
        stack.push("city");
        stack.push("country");
    }

    @Test
    public void whenDeleteElementThenGetZeroReturnCity() {
        assertThat(stack.poll(), is("country"));
        assertThat(stack.getList().get(0), is("city"));
    }

    @Test
    public void whenIterateStack() {
        Iterator<String> it = stack.getList().iterator();
        assertThat(it.next(), is("country"));
        assertThat(it.hasNext(), is(true));
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenChangeStackThenIteratorException() {
        Iterator<String> it = stack.getList().iterator();
        assertThat(it.next(), is("country"));
        stack.push("hello");
        it.next();
    }

}