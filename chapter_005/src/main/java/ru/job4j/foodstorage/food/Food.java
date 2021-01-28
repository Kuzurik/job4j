package ru.job4j.foodstorage.food;

import java.util.Calendar;

public class Food {
    private final String name;
    private Calendar expireDate;
    private Calendar createDate;
    private final int price;
    private long discount;

    public Food(String name, Calendar expireDate, Calendar createDate, int price, int discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Calendar getExpireDate() {
        return expireDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public void setCreateDate(Calendar created) {
        this.createDate = created;
    }

    public void setExpireDate(Calendar expired) {
        this.expireDate = expired;
    }
}
