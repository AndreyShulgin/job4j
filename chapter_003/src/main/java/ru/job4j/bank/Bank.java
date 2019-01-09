package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    Map<User, List<Account>> userAccounts = new HashMap<>();

    public void addUser(User user) {
        userAccounts.putIfAbsent(user, user.accountList);
    }

    public void deleteUser(User user) {
        userAccounts.remove(user);
    }

    public void addAccountToUser(User user, Account account) {
        user.accountList.add(account);
    }

    public void deleteAccountFromUser(User user, Account account) {
        user.accountList.remove(account);
    }

    public List<Account> getUserAccounts (User user) {
        return new ArrayList<>(user.accountList);
    }
}