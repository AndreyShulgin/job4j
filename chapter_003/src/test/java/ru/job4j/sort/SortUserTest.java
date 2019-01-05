package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class SortUserTest {

    @Test
    public void whenSortListThenTreeSet() {
        User user1 = new User("Andrey", 27);
        User user2 = new User("Alex", 25);
        Set<User> expect = new TreeSet<>();
        expect.add(user2);
        expect.add(user1);
        assertThat(new SortUser().sort(Arrays.asList(user1, user2)), is(expect));
    }

    @Test
    public void whenSortListThenNameLength() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Alex", 25);
        User user2 = new User("Andrey", 27);
        List<User> result = Arrays.asList(user1, user2);
        sortUser.sortNameLength(result);
        assertThat(result.get(0).getName(), is("Andrey"));
    }
}