package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Andrey Shulgin (neonod404@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
        boolean existense = false;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                items[index] = item;
                existense = true;
                break;
            }
        }
        return existense;
    }

    /**
     * Метод удаляет заявку по уникальному ключу.
     * @param id Уникальный ключ.
     */
    public boolean delete(String id) {
        boolean existence = false;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                System.arraycopy(items, index + 1, items, index, position - index);
                position--;
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
    public Item[] findAll() {
        Item[] itemsAll = new Item[position];
        System.arraycopy(items, 0, itemsAll, 0, position);
        return itemsAll;
    }

    /**
     * Метод ищет все заявки с одинаковым именем и копирует их в отдельный массив.
     * @param key Ключевое имя.
     * @return Возвращает массив с заявками, в котрых имя совдает с ключевым именем.
     */
    public Item[] findByName(String key) {
        Item[] names = new Item[position];
        int namesCount = 0;
        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                names[namesCount++] = items[i];
            }
        }
        return Arrays.copyOf(names, namesCount);
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