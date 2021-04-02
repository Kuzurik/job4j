package ru.job4j.foodstorage;

import ru.job4j.foodstorage.food.Food;
import ru.job4j.foodstorage.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Storage> storages;

    public ControlQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void distribute(Food food) {
        for(Storage value : storages) {
            if(value.accept((food))) {
                value.add(food);
                break;
            }
        }
    }


}
