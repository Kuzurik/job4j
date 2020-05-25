package ru.job4j.bankingtransfers;

import org.junit.Test;
import ru.job4j.bankingtransfers.Account;
import ru.job4j.bankingtransfers.Bank;
import ru.job4j.bankingtransfers.User;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Alex", "900"));
        bank.addUser(new User("Nick", "650"));
        assertThat(2, is(bank.accounts.size()));
    }

    @Test
    public void whenSetPassportReturnUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Alex", "900"));
        bank.addUser(new User("Nick", "650"));
        User result = new User("Alex", "900");
        assertThat(result, is(bank.findUser("900")));
    }

    @Test
    public void whenGetAccount() {
        Bank bank = new Bank();
        bank.addUser(new User("Alex", "900"));
        bank.addAccountToUser("900", new Account(200, "1425"));
        bank.addAccountToUser("900", new Account(300, "1578"));
        Account result = new Account(200, "1425");
        assertThat(result, is(bank.getAccount("900", "1425")));
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Alex", "900"));
        bank.addUser(new User("Nick", "650"));
        bank.addUser(new User("John", "800"));
        bank.addUser(new User("Jack", "80"));
        bank.deleteUser(new User("Nick", "650"));
        assertThat(3, is(bank.accounts.size()));
    }

    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Alex", "900"));
        bank.addAccountToUser("900", new Account(200, "1425"));
        bank.addAccountToUser("900", new Account(300, "1578"));
        List<Account> result = List.of(
                new Account(200, "1425"),
                new Account(300, "1578"));
        assertThat(result, is(bank.getUserAccounts("900")));
    }

    @Test
    public void whenDeleteAccountToUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Alex", "900"));
        bank.addAccountToUser("900", new Account(200, "1425"));
        bank.addAccountToUser("900", new Account(300, "1578"));
        bank.deleteAccountFromUser("900", new Account(200, "1425"));
        List<Account> result = List.of(new Account(300, "1578"));
        assertThat(result, is(bank.getUserAccounts("900")));
    }

    @Test
    public void whenTransferMoney() {
        Bank bank = new Bank();
        bank.addUser(new User("Alex", "900"));
        bank.addAccountToUser("900", new Account(200, "1425"));
        bank.addAccountToUser("900", new Account(300, "1578"));
        bank.transferMoney("900", "1425", "900", "1578", 150);
        List<Account> result = List.of(
                new Account(50, "1425"),
                new Account(450, "1578"));
        assertThat(result, is(bank.getUserAccounts("900")));
    }
}
