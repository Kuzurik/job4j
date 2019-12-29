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

    public void addAccountToUser(String passport, Account account) {
        for(Map.Entry<User, List<Account>> entry : accounts.entrySet()) {
            if(entry.getKey().getPassport().equals(passport)) {
                List<Account> accounts = entry.getValue();
                if(!accounts.contains(account)) {
                    accounts.add(account);
                }
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : accounts.entrySet()) {
            if(entry.getKey().getPassport().equals(passport)) {
                List<Account> accounts = entry.getValue();
                accounts.remove(account);
                entry.setValue(accounts);
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>();
        for(Map.Entry<User, List<Account>> entry : accounts.entrySet()) {
            if(entry.getKey().getPassport().equals(passport)) {
                list = entry.getValue();
            }
        }
        return list;
    }

    public boolean transferMoney(String srcPassport, String srcRequisites, String destPassport, String destRequisites, double amount) {
        boolean result = false;
        double value;
        Account srcAccount = checkAccount(srcPassport,srcRequisites);
        Account destAccount = checkAccount(destPassport, destRequisites);
        if(!srcAccount.getRequisites().isEmpty()) {
            value = srcAccount.getValue();
            if (amount <= value) {
                value -= amount;
                srcAccount.setValue(value);
                result = true;
            }
            if (result && !destAccount.getRequisites().isEmpty()) {
                value = destAccount.getValue();
                value += amount;
                destAccount.setValue(value);
            }
        }
        return result;
    }

    public Account checkAccount(String passport, String requisites) {
        Account result = new Account();
        for(Map.Entry<User, List<Account>> entry : accounts.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                List<Account> temp = entry.getValue();
                for (Account account : temp) {
                    if (account.getRequisites().equals(requisites)) {
                        result = account;
                    }
                }
            }
        }
            return result;
    }
}
