package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private final LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        for (Task x : tasks) {
            if (x != null && x.getPriority() > task.getPriority()) {
                break;
            }
            index++;
        }
        tasks.add(index, task);
    }


    public Task take() {
        return this.tasks.poll();
    }
}