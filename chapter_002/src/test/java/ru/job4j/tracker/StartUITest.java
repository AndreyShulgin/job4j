package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    /**
     * Тест метода showAllItem.
     */
    @Test
    public void whenFindAllThenAllItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Input input = new StubInput(new String[] {"1", "6"});
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is("0. Добавить новую заявку\n" +
                        "1. Показать все заявки\n" +
                        "2. Редактировать заявку\n" +
                        "3. Удалить заявку\n" +
                        "4. Поиск заявки по уникальному ключу (ID)\n" +
                        "5. Поиск заявки по имени\n" +
                        "6. Выход\r\n" +
                        "------------ Список заявок --------------\r\n" +
                        "name\r\n" +
                        "name1\r\n" +
                        "0. Добавить новую заявку\n" +
                        "1. Показать все заявки\n" +
                        "2. Редактировать заявку\n" +
                        "3. Удалить заявку\n" +
                        "4. Поиск заявки по уникальному ключу (ID)\n" +
                        "5. Поиск заявки по имени\n" +
                        "6. Выход\r\n"));
        System.setOut(stdout);
    }
    /**
     * Тест метода findItemsByName.
     */
    @Test
    public void whenFindByNameThenDescNames() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc1"));
        Item item1 = tracker.add(new Item("name", "desc2"));
        Input input = new StubInput(new String[] {"5", "name", "6"});
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        "0. Добавить новую заявку\n" +
                                "1. Показать все заявки\n" +
                                "2. Редактировать заявку\n" +
                                "3. Удалить заявку\n" +
                                "4. Поиск заявки по уникальному ключу (ID)\n" +
                                "5. Поиск заявки по имени\n" +
                                "6. Выход\r\n" +
                                "------------ Поиск заявок по имени --------------\r\n" +
                                "desc1\r\n" +
                                "desc2\r\n" +
                                "0. Добавить новую заявку\n" +
                                "1. Показать все заявки\n" +
                                "2. Редактировать заявку\n" +
                                "3. Удалить заявку\n" +
                                "4. Поиск заявки по уникальному ключу (ID)\n" +
                                "5. Поиск заявки по имени\n" +
                                "6. Выход\r\n"));
        System.setOut(stdout);
    }
}