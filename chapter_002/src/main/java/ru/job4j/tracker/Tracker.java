package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Andrey Shulgin (neonod404@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Список для хранение заявок.
     */
    private List<Item> items = new ArrayList<>();

    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод заменяет заявку по уникальному ключу.
     * @param id Уникальный ключ.
     * @param item Новая заявка.
     */
    public boolean replace(String id, Item item) {
        item.setId(id);
        boolean existence = false;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                items.set(index, item);
                existence = true;
                break;
            }
        }
        return existence;
    }

    /**
     * Метод удаляет заявку по уникальному ключу.
     * @param id Уникальный ключ.
     */
    public boolean delete(String id) {
        boolean existence = false;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                items.remove(index);
                existence = true;
                break;
            }
        }
        return existence;
    }

    /**
     * Метод копирует все заполненные заявки в другой массив.
     * @return Возвращает копию массива без Null элементов.
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Метод ищет все заявки с одинаковым именем и копирует их в отдельный массив.
     * @param key Ключевое имя.
     * @return Возвращает массив с заявками, в котрых имя совдает с ключевым именем.
     */
    public List<Item> findByName(String key) {
        List<Item> names = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(key)) {
                names.add(item);
            }
        }
        return names;
    }

    /**
     * Метод ищет заявки по уникальному ключу.
     * @param id Уникальный ключ.
     * @return Возвращает заявку по ключу.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }

        return result;
    }
}