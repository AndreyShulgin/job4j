package ru.job4j.bank;

import java.util.*;

public class Bank {
    Map<User, List<Account>> userAccounts = new HashMap<>();

    public void addUser(User user) {
        userAccounts.putIfAbsent(user, user.accountList);
    }

    public void deleteUser(User user) {
        userAccounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : userAccounts.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getKey().accountList.add(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : userAccounts.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getKey().accountList.remove(account);
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : userAccounts.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                accounts = entry.getKey().accountList;
            }
        }
        return accounts;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        List<Account> srcAccount = getUserAccounts(srcPassport);
        List<Account> dstAccount = getUserAccounts(destPassport);
        return srcAccount.contains(srcRequisite)
                && dstAccount.contains(dstRequisite)
                && srcAccount.get(srcAccount.indexOf(srcRequisite)).getValue() >= amount;
    }

}