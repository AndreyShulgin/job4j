package ru.job4j.list;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

        @Override
        public int hashCode() {
            return Objects.hash(name, children, birthday);
        }
    }

    @Test
    public void map() {
        Calendar calendar = new Calendar() {
            @Override
            protected void computeTime() {

            }

            @Override
            protected void computeFields() {

            }

            @Override
            public void add(int field, int amount) {

            }

            @Override
            public void roll(int field, boolean up) {

            }

            @Override
            public int getMinimum(int field) {
                return 0;
            }

            @Override
            public int getMaximum(int field) {
                return 0;
            }

            @Override
            public int getGreatestMinimum(int field) {
                return 0;
            }

            @Override
            public int getLeastMaximum(int field) {
                return 0;
            }
        };
        User user1 = new User("Andrey", 0, calendar);
        User user2 = new User("Andrey", 0, calendar);
        Map<User, Object> map = new HashMap<>();

        map.put(user1, 1);
        map.put(user2, 2);
        System.out.println(map);
    }
}
