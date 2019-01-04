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
    public void fillActions(StartUI startUI) {
        this.actions.add(new AddItem(0, "Добавить новую заявку"));
        this.actions.add(new ShowItems(1, "Список заявок"));
        this.actions.add(new UpdateItem(2, "Редактировать заявку"));
        this.actions.add(new DeleteItem(3, "Удалить заявку"));
        this.actions.add(new FindItemById(4, "Поиск заявки по уникальному ключу (ID)"));
        this.actions.add(new FindItemsByName(5, "Поиск заявок по имени"));
        this.actions.add(new ExitProgram(startUI));
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

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
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
    }

    private class UpdateItem extends BaseAction {

        public UpdateItem (int key, String name) {
            super(key, name);
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
    }

    private class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Список заявок --------------");
            List<Item> all = tracker.findAll();
            for (Item anAll : all) {
                System.out.println(anAll.getName());
                System.out.println(anAll.getDesc());
            }
        }
    }
    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
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
    }
    private class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по уникальному ключу (ID) --------------");
            String id = input.ask("Введите уникальный ключ (ID) заявки :");
            Item byId = tracker.findById(id);
            if (byId != null) {
                System.out.println("Имя заявки :" + System.lineSeparator() + byId.getName());
                System.out.println("Описание :" + System.lineSeparator() + byId.getDesc());
            } else {
                System.out.println("Заявка с таким ID не найдена.");
            }
        }
    }

    private class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по имени --------------");
            String key = input.ask("Введите имя для поиска :");
            List<Item> items = tracker.findByName(key);
            for (Item item : items) {
                System.out.println(item.getDesc());
            }
        }
    }
    private class ExitProgram implements UserAction {
        private final StartUI startUI;

        private ExitProgram(StartUI startUI) {
            this.startUI = startUI;
        }

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            this.startUI.stopWork();
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Выход");
        }
    }
}