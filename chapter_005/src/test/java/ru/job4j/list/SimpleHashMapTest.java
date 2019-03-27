package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {

    @Test
    public void whenAddElementThenAdd() {
        SimpleHashMap<String, Integer> shm = new SimpleHashMap<>(3);
        shm.insert("Name", 12);
        shm.insert("Name2", 15);
        shm.insert("Name3", 20);
        assertThat(shm.get("Name2"), is(15));
    }

    @Test
    public void whenDeleteElementThenDelete() {
        SimpleHashMap<String, Integer> shm = new SimpleHashMap<>(3);
        shm.insert("Name", 12);
        shm.insert("Name2", 15);
        shm.insert("Name3", 20);
        shm.delete("Name");
        assertNull(shm.get("Name"));
    }
}