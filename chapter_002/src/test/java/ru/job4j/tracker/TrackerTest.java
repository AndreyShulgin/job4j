package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    /**
     * Тест метода Add.
     */
    @Test
    public void whenAddNewItemThenItems() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        assertThat(tracker.add(item), is(item));
    }

    /**
     * Тест метода Replace.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test2","testDescription2",1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Тест метода Delete.
     */
    @Test
    public void whenDeleteOneItemThenItems() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test1","testDescription2",1234L);
        tracker.add(next);
        Item next2 = new Item("test2","testDescription2",1234L);
        tracker.add(next2);
        tracker.delete(previous.getId());
        assertNull(tracker.findById(previous.getId()));
    }

    /**
     * Тест метода FindAll.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Тест метода FindByName.
     */
    @Test
    public void whenFindByNameThenItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test1","testDescription2",1234L);
        tracker.add(next);
        Item next2 = new Item("test2","testDescription2",1234L);
        tracker.add(next2);
        Item[] result = tracker.findByName("test1");
        Item[] except = {previous, next};
        assertThat(result, is(except));
    }

    /**
     * Тест метода FindById.
     * В массиве с заданным ID есть элемент.
     */
    @Test
    public void whenFindByIdThenItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test2","testDescription2",1234L);
        tracker.add(next);
        assertThat(tracker.findById(next.getId()).getName(), is("test2"));
    }

    /**
     * Тест метода FindById.
     * В массиве с заданным ID нет элемента.
     */
    @Test
    public void whenFindByIdThenNotItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test2","testDescription2",1234L);
        assertNull(tracker.findById(next.getId()));
    }
}