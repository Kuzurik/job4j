package ru.job4j.foodstorage.food;

import java.util.Calendar;

public class Rice extends Food{
    public Rice(String name, Calendar expireDate, Calendar createDate, int price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
