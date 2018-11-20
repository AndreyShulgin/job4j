package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenItems() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        assertThat(tracker.add(item), is(item));// add
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item)); // findAll
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2","testDescription2",1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2")); // Replace
    }
    @Test
    public void whenFindByIdThenItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test2","testDescription2",1234L);
        tracker.add(previous);
        assertThat(tracker.findById(previous.getId()).getName(), is("test1")); // findById
    }
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
        assertThat(result, is(except));// findbyname
    }

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
        String except = null;
        assertThat(tracker.findById(previous.getId()), is(except));// delete
    }
}