package ru.job4j.list;

import java.util.Calendar;

public class MapTest {

    public static final class User {
        String name;
        int children;
        Calendar birthday;

        public User(String name, int children, Calendar birthday) {
            this.name = name;
            this.children = children;
            this.birthday = birthday;
        }
    }
}
