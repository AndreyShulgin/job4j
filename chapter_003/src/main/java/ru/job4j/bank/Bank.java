package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class Bank {
    Map<User, List<Account>> userAccounts = new HashMap<>();

    public void addUser(User user) {
        userAccounts.putIfAbsent(user, user.accountList);
    }

    public void deleteUser(User user) {
        userAccounts.remove(user);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void addAccountToUser(String passport, Account account) {
        userAccounts.entrySet().stream()
                .filter(userListEntry -> userListEntry.getKey().getPassport().contains(passport))
                .map(userListEntry -> userListEntry.getValue().add(account))
                .collect(Collectors.toList());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void deleteAccountFromUser(String passport, Account account) {
        userAccounts.entrySet().stream()
                .filter(userListEntry -> userListEntry.getKey().getPassport().contains(passport))
                .map(userListEntry -> userListEntry.getKey().accountList.remove(account))
                .collect(Collectors.toList());
    }

    public List<Account> getUserAccounts(String passport) {
        return userAccounts.entrySet().stream()
                .filter(userListEntry -> userListEntry.getKey().getPassport().contains(passport))
                .flatMap(userListEntry -> userListEntry.getValue().stream())
                .collect(Collectors.toList());
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean rst = false;
        Account srcAccount = getAcc(srcPassport, srcRequisite);
        Account dstAccount = getAcc(destPassport, dstRequisite);
        if (srcAccount != null && dstAccount !=  null && srcAccount.getValue() >= amount) {
            srcAccount.setValue(srcAccount.getValue() - amount);
            dstAccount.setValue(dstAccount.getValue() + amount);
            rst = true;
        }
        return rst;
    }

    public Account getAcc(String pass, String req) {
       return userAccounts.entrySet().stream()
                .filter(userListEntry -> userListEntry.getKey().getPassport().contains(pass))
                .flatMap(userListEntry -> userListEntry.getKey().accountList.stream())
                .filter(account -> account.getRequisites().contains(req))
                .findFirst().orElse(null);
    }

}