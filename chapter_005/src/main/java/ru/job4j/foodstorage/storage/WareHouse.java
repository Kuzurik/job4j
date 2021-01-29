package ru.job4j.foodstorage.storage;

import ru.job4j.foodstorage.food.Food;

import java.util.ArrayList;
import java.util.List;

public class WareHouse implements Storage {
    private final List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        this.foods.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return countPercent(food) < 25;
    }

    @Override
    public List<Food> clear() {
        List<Food> result = new ArrayList<>(foods);
        foods.clear();
        return result;
    }
}
