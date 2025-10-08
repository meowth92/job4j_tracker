package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                users.remove(user);
            }
        }
    }

    public void addAccount(String passport, Account account) {
        User user = this.findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }

    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = this.findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account accountSrc = findByRequisite(sourcePassport, sourceRequisite);
        Account accountDst = findByRequisite(destinationPassport, destinationRequisite);
        if (accountSrc == null || accountDst == null || amount > accountSrc.getBalance()) {
            return false;
        }
        accountSrc.setBalance(accountSrc.getBalance() - amount);
        accountDst.setBalance(accountDst.getBalance() + amount);
        return true;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}