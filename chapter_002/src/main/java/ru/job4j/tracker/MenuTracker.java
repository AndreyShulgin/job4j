package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * хранит ссылку на объект .
     */
    private final Input input;
    /**
     * хранит ссылку на объект .
     */
    private final Tracker tracker;
    /**
     * хранит ссылку на массив типа UserAction.
     */
    private final List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new UpdateItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
        this.actions.add(new ExitProgram());
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Добавить новую заявку");
        }
    }

    private class UpdateItem implements UserAction {
        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Введите уникальны ключ (ID) вашей заявки :");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("Заявка изменена.");
            } else {
                System.out.println("Заявка с таким ID не найдена.");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Редактировать заявку");
        }
    }

    private class ShowItems implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Список заявок --------------");
            Item[] all = tracker.findAll();
            for (Item anAll : all) {
                System.out.println(anAll.getName());
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Список заявок");
        }
    }
    private class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите уникальный ключ (ID) заявки для удаления :");
            if (tracker.delete(id)) {
                System.out.println("Заявка удалена.");
            } else {
                System.out.println("Заявка не найдена.");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удалить заявку");
        }
    }
    private class FindItemById implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по уникальному ключу (ID) --------------");
            String id = input.ask("Введите уникальный ключ (ID) заявки :");
            Item byId = tracker.findById(id);
            if (byId != null) {
                System.out.println("Имя заявки :\n" + byId.getName());
                System.out.println("Описание :\n" + byId.getDesc());
            } else {
                System.out.println("Заявка с таким ID не найдена.");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявки по уникальному ключу (ID)");
        }
    }

    private class FindItemsByName implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по имени --------------");
            String key = input.ask("Введите имя для поиска :");
            Item[] items = tracker.findByName(key);
            for (Item item : items) {
                System.out.println(item.getDesc());
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявок по имени");
        }
    }
    private class ExitProgram implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            StartUI startUI = new StartUI(input, tracker);
            startUI.exit();
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Выход");
        }
    }
}