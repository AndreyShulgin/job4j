package ru.job4j.tracker;

import java.util.Random;

/**
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

    public void replace(String id, Item item) {
        for (int index = 0; index < items.length; index++) {
            if (items[index].getId().equals(id)) {
                items[index] = item;
                break;
            }
        }
    }

    public void delete(String id) {
        Item[] result = new Item[position - 1];
        for (int index = 0; index < items.length; index++) {
            if (items[index].getId().equals(id)) {
                System.arraycopy(items, 0, result, 0, index);
                System.arraycopy(items, index + 1, result, index, items.length - index);
            }
        }
    }

    public Item[] findAll() {
        Item[] itemsAll = new Item[position];
        System.arraycopy(items, 0, itemsAll, 0, position);
        return itemsAll;
    }

    public Item[] findByName(String key) {
        int count = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                count++;
            }
        }
        Item[] names = new Item[count];
        int namesCount=0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                names[namesCount] = item;
            }
        }
        return names;
    }

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