package ru.job4j.tracker;

import java.util.List;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe ) {
                System.out.println("Пожалуйста, введите корректные данные");
            } catch (MenuOutException moe) {
                System.out.println("Необходимо выбрать значение из диапазона меню");
            }
        }while (invalid);
        return value;
    }
}