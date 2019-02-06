package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class SortUserTest {

    @Test
    public void whenSortListThenTreeSet() {
        List<User> list = List.of(new User("Andrey", 27),
                new User("Alex", 25));
        Set<User> expect = Set.of(new User("Andrey", 27),
                new User("Alex", 25));
        assertThat(new SortUser().sort(list), is(expect));
    }

    @Test
    public void whenSortListThenNameLength() {
        List<User> result = new ArrayList<>(List.of(new User("Alex", 25),
                new User("Andrey", 27)));
        assertThat(new SortUser().sortNameLength(result).get(0).getName(), is("Andrey"));
    }

    @Test
    public void whenSortListThenNameAndAge() {
        List<User> result = new ArrayList<>(List.of(new User("Alex", 25),
                new User("Andrey", 27),
                new User("Alex", 10)));
        assertThat(new SortUser().sortByAllFields(result).get(0).getAge(), is(10));
    }
}