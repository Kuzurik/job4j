package ru.job4j.bankingtransfers;

import java.util.*;

public class Bank {
    public Map<User, List<Account>> accounts = new HashMap<>();

    public User findUser(String passport) {
         return this.accounts.keySet().stream().filter(usr -> usr.getPassport().equals(passport)).findFirst().orElse(null);
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
        return list.stream().filter(account -> account.getRequisites().equals(requisite)).findFirst().orElse(null);
    }

    public void addAccountToUser(String passport, Account account) {
        if (findUser(passport) != null) {
            this.accounts.get(findUser(passport)).add(account);
        }


    }

    public void deleteAccountFromUser(String passport, Account account) {
       if(findUser(passport) != null) {
           this.accounts.get(findUser(passport)).remove(account);
       }
      }

    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        if (findUser(passport) != null){
            accounts = this.accounts.get(findUser(passport));
        }
        return accounts;
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
