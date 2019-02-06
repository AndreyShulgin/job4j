package ru.job4j.list;

import org.junit.Test;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class UserConvertTest {

    @Test
    public void whenListUserThenHashMap() {
        UserConvert userConvert = new UserConvert();
        User user1 = new User("Andrey", 27, "Moscow");
        User user2 = new User("Alex", 16, "New York");
        HashMap<Integer, User> result = userConvert.process(List.of(user1, user2));
        HashMap<Integer, User> expect = new HashMap<>(Map.of(27, user1, 16, user2));
        assertThat(result, is(expect));
    }
}