package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {
    /**
     * Тест метода createItem.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("name"));
    }

    /**
     * тест метода editItem.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input inputUpdate = new StubInput(new String[] {"2", item.getId(), "new name", "new desc", "6"});
        new StartUI(inputUpdate, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("new name"));
    }

    /**
     * Тест метода editItem.
     * Заявка не найдена.
     */
    @Test
    public void whenUpdateThenTrackerHasNotUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input inputUpdate = new StubInput(new String[] {"2", "неправильный ID", "new name", "new desc", "6"});
        new StartUI(inputUpdate, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("name"));
    }

    /**
     * Тест метода deleteItem.
     */
    @Test
    public void whenDeleteThenHasDeletedItem() {
        Tracker tracker = new Tracker();
        Item item0 = tracker.add(new Item("name", "desc"));
        Item item1 = tracker.add(new Item("name delete", "desc delete"));
        Input input = new StubInput(new String[] {"3", item0.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("name delete"));
    }
    /**
     * Тест метода deleteItem.
     * Заявка не найдена.
     */
    @Test
    public void whenDeleteThenItemNotFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[] {"3", "неправильный ID", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("name"));
    }

       /**
        * Тест метода findItemById.
        */
    @Test
    public void whenFindByIdThenItemFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[] {"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
    }

    /**
     * Тест метода findItemById.
     * Заявка не найдена.
     */
    @Test
    public void whenFindByIdThenNotFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[] {"4", "неправильный ID", "6"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById("неправильный ID"));
    }

}