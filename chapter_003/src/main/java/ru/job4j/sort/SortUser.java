package ru.job4j.sort;

import java.util.*;

public class SortUser {

    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength(List<User> list) {
        list.sort((o1, o2) -> Integer.compare(o2.getName().length(), o1.getName().length()));
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort((o1, o2) -> {
            int result;
            result = o1.getName().compareTo(o2.getName());
            if (result == 0) {
                result = Integer.compare(o1.getAge(), o2.getAge());
            }
            return result;
        });
        return list;
    }
}