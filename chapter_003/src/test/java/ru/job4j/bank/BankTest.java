package ru.job4j.bank;

import org.junit.Test;

import java.util.List;

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

    @Test
    public void whenDeleteUserThenDelete() {
        Bank bank = new Bank();
        User user = new User("Andrey", "1234");
        bank.addUser(user);
        bank.deleteUser(user);
        assertThat(bank.userAccounts.keySet().contains(user), is(false));
    }

    @Test
    public void whenAddAccountThenAdd() {
        Bank bank = new Bank();
        User user = new User("Andrey", "1234");
        Account account = new Account(5, "req");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), account);
        assertThat(user.accountList.get(0).getRequisites(), is("req"));
    }

    @Test
    public void whenDeleteAccountThenDelete() {
        Bank bank = new Bank();
        User user = new User("Andrey", "1234");
        Account account1 = new Account(5, "req");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), account1);
        bank.deleteAccountFromUser(user.getPassport(), account1);
        assertThat(user.accountList.contains(account1), is(false));
    }

    @Test
    public void whenGetUserAccountThenList() {
        Bank bank = new Bank();
        User user = new User("Andrey", "1234");
        Account account1 = new Account(5, "req");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), account1);
        List<Account> result = bank.getUserAccounts(user.getPassport());
        assertThat(result.get(0).getRequisites(), is("req"));
    }

    @Test
    public void whenTransferMoneyThenTrue() {
        Bank bank = new Bank();
        User user1 = new User("Andrey", "1111");
        Account account1 = new Account(10, "req1");
        User user2 = new User("Alex", "2222");
        Account account2 = new Account(5, "req2");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser("1111", account1);
        bank.addAccountToUser("2222", account2);
        boolean result = bank.transferMoney("1111", "req1", "2222", "req2", 3);
        assertThat(result, is(true));
    }

    @Test
    public void whenTransferMoneyThenFalse() {
        Bank bank = new Bank();
        User user1 = new User("Andrey", "1111");
        Account account1 = new Account(10, "req1");
        User user2 = new User("Alex", "2222");
        Account account2 = new Account(5, "req2");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser("1111", account1);
        bank.addAccountToUser("2222", account2);
        boolean result = bank.transferMoney("2222", "req2", "1111", "req1", 7);
        assertThat(result, is(false));
    }

    @Test
    public void whenTransferMoneyThenAccountNotFound() {
        Bank bank = new Bank();
        User user1 = new User("Andrey", "1111");
        Account account1 = new Account(10, "req1");
        User user2 = new User("Alex", "2222");
        Account account2 = new Account(5, "req2");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser("1111", account1);
        bank.addAccountToUser("2222", account2);
        boolean result = bank.transferMoney("1111", "req3", "2222", "req2", 3);
        assertThat(result, is(false));
    }

    @Test
    public void whenTransferMoneyThenUserNotFound() {
        Bank bank = new Bank();
        User user1 = new User("Andrey", "1111");
        Account account1 = new Account(10, "req1");
        User user2 = new User("Alex", "2222");
        Account account2 = new Account(5, "req2");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser("1111", account1);
        bank.addAccountToUser("2222", account2);
        boolean result = bank.transferMoney("3333", "req1", "2222", "req2", 3);
        assertThat(result, is(false));
    }
}