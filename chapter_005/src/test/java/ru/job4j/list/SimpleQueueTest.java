package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {
    private SimpleQueue<Integer> queue;

    @Before
    public void createQueue() {
        queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
    }

    @Test
    public void poll() {
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        queue.push(4);
        assertThat(queue.poll(), is(4));
        assertThat(queue.poll(), is(3));
    }
}