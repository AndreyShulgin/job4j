package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {
    private SimpleQueue<String> queue;

    @Before
    public void createQueue() {
        queue = new SimpleQueue<>();
        queue.push("Name");
        queue.push("Address");
        queue.push("City");
    }

    @Test
    public void poll() {
        assertThat(queue.poll(), is("Name"));
        assertThat(queue.poll(), is("Address"));
        assertThat(queue.poll(), is("City"));
    }


}