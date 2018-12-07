package ru.job4j.tracker;

import java.util.List;

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста, введите корректные данные");
            } catch (MenuOutException moe) {
                System.out.println("Необходимо выбрать значение из диапозона меню");
            }
        } while (invalid);
        return value;
    }
}