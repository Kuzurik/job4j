package ru.job4j.bankingtransfers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    public Map<User, List<Account>> accounts = new HashMap<>();

    public void addUser(User user) {
        accounts.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.accounts.remove(user);
    }

    public User getUserByPassport(String passport) {
        User result = null;
        for (User userByPassport : accounts.keySet()) {
            if (userByPassport.getPassport().equals(passport)) {
                result = userByPassport;
                break;
            }
        }
        return result;
    }

    public Account getAccount(String passport, String requisite) {
        Account result = null;
        User user = this.getUserByPassport(passport);
        List<Account> list = accounts.get(user);
        for (Account account : list) {
            if (account.getRequisites().equals(requisite)) {
                result = account;
                break;
            }
        }
        return result;
    }

    public void addAccountToUser(String passport, Account account) {
        List<Account> accounts = this.accounts.get(getUserByPassport(passport));
        if (!accounts.contains(account)) {
            accounts.add(account);
        }


    }

    public void deleteAccountFromUser(String passport, Account account) {
       this.accounts.get(getUserByPassport(passport)).remove(account);
      }

    public List<Account> getUserAccounts(String passport) {
        return this.accounts.get(getUserByPassport(passport));
    }

    public boolean transferMoney(String srcPassport, String srcRequisites, String destPassport, String destRequisites, double amount) {
        boolean result = false;
        Account srcAccount = getAccount(srcPassport, srcRequisites);
        Account destAccount = getAccount(destPassport, destRequisites);
        if (!srcAccount.getRequisites().isEmpty() && !destAccount.getRequisites().isEmpty()) {
            result = srcAccount.transfer(destAccount, amount);
        }
        return result;
    }

}
