package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    private final Consumer<String> output;
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    private boolean work = true;

    /**
     * Конструтор инициализирующий поля.
     * @param output
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Consumer<String> output, Input input, Tracker tracker) {
        this.output = output;
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("Выберите :", range));
        } while (this.work);
    }
    public void stopWork() {
        this.work = false;
    }
    /**
     * Запускт программы.
     * @param args - Args.
     */
    public static void main(String[] args) {
        new StartUI(
                System.out :: println, new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}