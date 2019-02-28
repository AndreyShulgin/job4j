package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AbstractStoreTest {
    @Test
    public void whenReplaceUser() {
        User user = new User("111");
        User user1 = new User("222");
        UserStore userStore = new UserStore();

        userStore.add(user);
        boolean result = userStore.replace("111", user1);

        assertThat(result, is(true));
    }

    @Test
    public void whenFindUserById() {
        User user = new User("111");
        User user1 = new User("222");
        UserStore userStore = new UserStore();

        userStore.add(user);
        userStore.add(user1);
        User rst = userStore.findById("222");

        assertThat(rst, is(user1));
    }

    @Test
    public void whenReplaceRole() {
        Role role = new Role("111");
        Role role1 = new Role("222");
        RoleStore roleStore = new RoleStore();

        roleStore.add(role);
        boolean result = roleStore.replace("111", role1);

        assertThat(result, is(true));
    }

    @Test
    public void whenFindRoleById() {
        Role role = new Role("111");
        Role role1 = new Role("222");
        RoleStore roleStore = new RoleStore();

        roleStore.add(role);
        Role rst = roleStore.findById("111");

        assertThat(rst, is(role));
    }

    @Test
    public void whenFindRoleByIdThenNotFound() {
        Role role = new Role("111");
        Role role1 = new Role("222");
        RoleStore roleStore = new RoleStore();

        roleStore.add(role);
        roleStore.add(role1);
        Role rst = roleStore.findById("333");

        assertNull(rst);
    }

    @Test
    public void whenDeleteUser() {
        User user = new User("111");
        User user1 = new User("222");
        UserStore userStore = new UserStore();

        userStore.add(user);
        userStore.add(user1);
        boolean rst = userStore.delete("111");
        assertThat(rst, is(true));
    }
}