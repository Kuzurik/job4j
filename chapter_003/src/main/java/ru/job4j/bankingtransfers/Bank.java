package ru.job4j.bankingtransfers;

import java.util.*;


public class Bank {
    public Map<User, List<Account>> accounts = new HashMap<>();

    public User findUser(String passport) {
        List<User> users = new ArrayList<>(this.accounts.keySet());
        return users.stream().filter(user -> user.getPassport().equals(passport)).findFirst().get();
    }

    public void addUser(User user) {
        accounts.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.accounts.remove(user);
    }


    public Account getAccount(String passport, String requisite) {
        User user = findUser(passport);
        List<Account> list = accounts.get(user);
        return list.stream().filter(account -> account.getRequisites().equals(requisite)).findFirst().get();
    }

    public void addAccountToUser(String passport, Account account) {
        List<Account> accounts = this.accounts.get(findUser(passport));
        if (!accounts.contains(account)) {
            accounts.add(account);
        }


    }

    public void deleteAccountFromUser(String passport, Account account) {
       this.accounts.get(findUser(passport)).remove(account);
      }

    public List<Account> getUserAccounts(String passport) {
        return this.accounts.get(findUser(passport));
    }

    public boolean transferMoney(String srcPassport, String srcRequisites, String destPassport, String destRequisites, double amount) {
        boolean result = false;
        Account srcAccount = getAccount(srcPassport, srcRequisites);
        Account destAccount = getAccount(destPassport, destRequisites);
        if (srcAccount != null && destAccount != null) {
            srcAccount.transfer(destAccount, amount);
            result = true;

        }
        return result;
    }

}
