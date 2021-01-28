package ru.job4j.foodstorage.storage;

import ru.job4j.foodstorage.food.Food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Shop implements Storage {
    private final List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public boolean accept(Food food) {
        long created = food.getCreateDate().getTimeInMillis();
        long expire = food.getExpireDate().getTimeInMillis();
        long accept = (((Calendar.getInstance().getTimeInMillis() - created) * 100) / (expire - created));
        if (accept >= 25 && accept < 100) {
            if (accept >= 75) {
                food.setDiscount(10);
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Food> clear() {
        List<Food> result = new ArrayList<>(foods);
        foods.clear();
        return result;
    }
}
