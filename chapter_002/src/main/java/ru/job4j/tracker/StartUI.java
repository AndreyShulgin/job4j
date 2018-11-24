
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
    public static final String FINDID = "4";

    /**
     * Константа меню для поиска одинаковых заявок.
     */
    public static final String FINDNAME = "5";

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
            } else if (FINDID.equals(answer)) {
                this.findItemById();
            } else if (FINDNAME.equals(answer)) {
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
        tracker.replace(id, item);
    }

    /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите уникальный ключ (ID) заявки для удаления :");
        tracker.delete(id);
        System.out.println("Заявка удалена.");
    }

    /**
     * Метод реализует поиск заявки по ID.
     */
    private void findItemById() {
        System.out.println("------------ Поиск заявки по уникальному ключу (ID) --------------");
        String id = this.input.ask("Введите уникальный ключ (ID) заявки :");
        System.out.println("Имя заявки :\n" + tracker.findById(id).getName());
        System.out.println("Описание :\n" + tracker.findById(id).getDesc());
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
        System.out.println("0. Добавить новую заявку\n" +
                "1. Показать все заявки\n" +
                "2. Редактировать заявку\n" +
                "3. Удалить заявку\n" +
                "4. Поиск заявки по уникальному ключу (ID)\n" +
                "5. Поиск заявки по имени\n" +
                "6. Выход");
    }

    /**
     * Запускт программы.
     * @param args - Args.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}