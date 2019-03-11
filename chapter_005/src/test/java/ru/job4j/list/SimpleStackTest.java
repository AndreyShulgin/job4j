package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;


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
    public void whenDeleteElement() {
        assertThat(stack.poll(), is("country"));
        assertThat(stack.poll(), is("city"));
        assertThat(stack.poll(), is("name"));
    }
}