package ru.job4j.sort;

import java.util.*;

public class SortUser {

    public Set<User> sort (List<User> list) {
        return new TreeSet<>(list);
    }
}