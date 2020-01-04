package ru.job4j.bankingtransfers;

import java.util.Objects;

public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public boolean transfer(Account account, double amount) {
        boolean result = false;
        if (amount > 0 && amount <= value && account != null) {
            this.value -= amount;
            account.value += amount;
            result = true;
        }
        return result;
    }

    public double getValue() {
        return this.value;
    }

    public String getRequisites() {
        return this.requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Account{"
                +
                "value=" + value
                +
                ", requisites=" + requisites
                +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Account account = (Account) obj;
        return Double.compare(account.value, value) == 0
                &&
                Objects.equals(requisites, account.requisites);

    }

    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }
}
