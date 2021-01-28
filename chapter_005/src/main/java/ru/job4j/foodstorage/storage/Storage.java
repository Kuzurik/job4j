package ru.job4j.foodstorage.storage;

import ru.job4j.foodstorage.food.Food;

import java.util.List;

public interface Storage {
    void add(Food food);

    boolean accept(Food food);

    List<Food> clear();
}
