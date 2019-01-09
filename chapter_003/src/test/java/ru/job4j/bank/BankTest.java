package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void whenAddUserAndAccount() {
        Bank bank = new Bank();
        User user = new User("Andrey", "1234");
        bank.addUser(user);
        assertThat(bank.userAccounts.values().contains(user.accountList), is(true));
    }
}