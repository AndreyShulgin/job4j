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
        Account srcAccount = getAcc(srcPassport, srcRequisite);
        Account dstAccount = getAcc(destPassport, dstRequisite);
        return srcAccount.getValue() != -1 && dstAccount.getValue() !=  -1 && srcAccount.getValue() >= amount;
    }

    public Account getAcc(String pass, String req) {
        Account account = new Account(-1, "1");
        for (Map.Entry<User, List<Account>> entry : userAccounts.entrySet()) {
            if (entry.getKey().getPassport().equals(pass)) {
                for (Account acc : entry.getKey().accountList) {
                    if (acc.getRequisites().equals(req)) {
                        account = entry.getKey().accountList.get
                                (entry.getKey().accountList.indexOf(acc));
                    }
                }
            }
        }
        return account;
    }

}