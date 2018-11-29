
package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для отображения всех заявок.
     */
    public static final String ALL = "1";

    /**
     * Константа меню для редактирования заявок.
     */
    public static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    public static final String DELETE = "3";

    /**
     * Константа меню для поиска по ID.
     */
    public static final String FIND_BY_ID = "4";

    /**
     * Константа меню для поиска одинаковых заявок.
     */
    public static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (ALL.equals(answer)) {
                this.showAllItem();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findItemsByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует отображение всех заявок.
     */
    private void showAllItem() {
        System.out.println("------------ Список заявок --------------");
        Item[] all = tracker.findAll();
        for (Item anAll : all) {
            System.out.println(anAll.getName());
        }
    }

    /**
     * Метод реализует редактирование заявки.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите уникальны ключ (ID) вашей заявки :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена.");
        } else {
            System.out.println("Заявка с таким ID не найдена.");
        }
    }

    /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите уникальный ключ (ID) заявки для удаления :");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена.");
        } else {
            System.out.println("Заявка не найдена.");
        }
    }

    /**
     * Метод реализует поиск заявки по ID.
     */
    private void findItemById() {
        System.out.println("------------ Поиск заявки по уникальному ключу (ID) --------------");
        String id = this.input.ask("Введите уникальный ключ (ID) заявки :");
        Item byId = tracker.findById(id);
        if (byId != null) {
            System.out.println("Имя заявки :\n" + byId.getName());
            System.out.println("Описание :\n" + byId.getDesc());
        } else {
            System.out.println("Заявка с таким ID не найдена.");
        }
    }

    /**
     * Метод реализует поиск заявки по имени.
     */
    private void findItemsByName() {
        System.out.println("------------ Поиск заявок по имени --------------");
        String key = this.input.ask("Введите имя для поиска :");
        Item[] items = tracker.findByName(key);
        for (Item item : items) {
            System.out.println(item.getDesc());
        }
    }


    private void showMenu() {
        String ls = System.lineSeparator();
        System.out.println(new StringBuilder()
                .append("0. Добавить новую заявку").append(ls)
                .append("1. Показать все заявки").append(ls)
                .append("2. Редактировать заявку").append(ls)
                .append("3. Удалить заявку").append(ls)
                .append("4. Поиск заявки по уникальному ключу (ID)").append(ls)
                .append("5. Поиск заявки по имени").append(ls)
                .append("6. Выход")
                .toString());
    }

    /**
     * Запускт программы.
     * @param args - Args.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}