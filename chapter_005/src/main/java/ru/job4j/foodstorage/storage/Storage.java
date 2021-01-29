package ru.job4j.foodstorage.storage;

import ru.job4j.foodstorage.food.Food;

import java.util.Calendar;
import java.util.List;

public interface Storage {
    void add(Food food);
    boolean accept(Food food);
    List<Food> clear();
    default long countPercent(Food food) {
        long created = food.getCreateDate().getTimeInMillis();
        long expire = food.getExpireDate().getTimeInMillis();
        return (((Calendar.getInstance().getTimeInMillis() - created) * 100) / (expire - created));
    }
}
