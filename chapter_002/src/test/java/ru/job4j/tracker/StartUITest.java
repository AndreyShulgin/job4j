package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
        @Override
        public String toString() {
            return out.toString();
        }
    };


    private String ls = System.lineSeparator();
    private String menu = new StringBuilder()
            .append("0. Добавить новую заявку").append(ls)
            .append("1. Список заявок").append(ls)
            .append("2. Редактировать заявку").append(ls)
            .append("3. Удалить заявку").append(ls)
            .append("4. Поиск заявки по уникальному ключу (ID)").append(ls)
            .append("5. Поиск заявок по имени").append(ls)
            .append("6. Выход").append(ls)
            .toString();
    /**
     * Тест метода createItem.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "name", "desc", "6"});
        new StartUI(output, input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("name"));
    }

    /**
     * тест метода editItem.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input inputUpdate = new StubInput(new String[] {"2", item.getId(), "new name", "new desc", "6"});
        new StartUI(output, inputUpdate, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("new name"));
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
        new StartUI(output, inputUpdate, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("name"));
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
        new StartUI(output, input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("name delete"));
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
        new StartUI(output, input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("name"));
    }

       /**
        * Тест метода findItemById.
        */
    @Test
    public void whenFindByIdThenItemFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[] {"4", item.getId(), "6"});
        new StartUI(output, input, tracker).init();
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
        new StartUI(output, input, tracker).init();
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
        new StartUI(output, input, tracker).init();
        assertThat(output.toString(),
                is("------------ Список заявок --------------" + System.lineSeparator()
                        + "name" + System.lineSeparator()
                        + "desc" + System.lineSeparator()
                        + "name1" + System.lineSeparator()
                        + "desc1" + System.lineSeparator()
                ));
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
        new StartUI(output, input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is("------------ Поиск заявок по имени --------------" + System.lineSeparator()
                        + "desc1" + System.lineSeparator()
                        + "desc2" + System.lineSeparator()
                )); }
}