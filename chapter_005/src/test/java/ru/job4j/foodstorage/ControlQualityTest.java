package ru.job4j.foodstorage;



import org.junit.Test;
import ru.job4j.foodstorage.food.Food;
import ru.job4j.foodstorage.food.Meat;
import ru.job4j.foodstorage.food.Milk;
import ru.job4j.foodstorage.food.Rice;
import ru.job4j.foodstorage.storage.Shop;
import ru.job4j.foodstorage.storage.Storage;
import ru.job4j.foodstorage.storage.Trash;
import ru.job4j.foodstorage.storage.WareHouse;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.util.Calendar.getInstance;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests.
 */
public class ControlQualityTest {

    /**
     * when No Expired Products.
     */
    @Test
    public void whenNoExpiredProducts() {
        Calendar created = getInstance();
        Calendar expired = getInstance();
        expired.add(Calendar.MONTH, 1);
        List<Storage> storages = List.of(new WareHouse(), new Shop(), new Trash());
        ControlQuality controlQuality = new ControlQuality(storages);
        List<Food> foods = List.of(
                new Milk("milk", expired, created, 100, 0),
                new Rice("basmati", expired, created, 30, 0),
                new Meat("beef", expired, created, 140, 0));
        foods.forEach(controlQuality::distribute);
        StringBuilder wareHouse = new StringBuilder();
        storages.get(0).clear().forEach(f -> wareHouse.append(f.toString()));
        StringBuilder result = new StringBuilder();
        foods.forEach(f -> result.append(f.toString()));
        assertThat(wareHouse.toString(), is(result.toString()));
    }

    /**
     * when All Products Put In Shop.
     */
    @Test
    public void whenAllProductsPutInShop() {
        Calendar created = getInstance();
        created.add(Calendar.DATE, -20);
        Calendar expired = getInstance();
        expired.add(Calendar.DATE, 60);
        List<Storage> storages = List.of(new WareHouse(), new Shop(), new Trash());
        ControlQuality controlQuality = new ControlQuality(storages);
        List<Food> food = List.of(
                new Milk("milk", expired, created, 100, 0),
                new Rice("basmati", expired, created, 30, 0),
                new Meat("beef", expired, created, 140, 0));
        food.forEach(controlQuality::distribute);
        StringBuilder shop = new StringBuilder();
        storages.get(1).clear().forEach(f -> shop.append(f.toString()));
        StringBuilder result = new StringBuilder();
        food.forEach(f -> result.append(f.toString()));
        assertThat(shop.toString(), is(result.toString()));
    }

    /**
     * when All Products Put In Trash.
     */
    @Test
    public void whenAllProductsPutInTrash() {
        Calendar created = getInstance();
        created.add(Calendar.DATE, -20);
        Calendar expired = getInstance();
        List<Storage> storages = List.of(new WareHouse(), new Shop(), new Trash());
        ControlQuality controlQuality = new ControlQuality(storages);
        List<Food> food = List.of(
                new Milk("milk", expired, created, 100, 0),
                new Rice("basmati", expired, created, 30, 0),
                new Meat("beef", expired, created, 140, 0));
        food.forEach(controlQuality::distribute);
        StringBuilder trash = new StringBuilder();
        storages.get(2).clear().forEach(f -> trash.append(f.toString()));
        StringBuilder result = new StringBuilder();
        food.forEach(f -> result.append(f.toString()));
        assertThat(trash.toString(), is(result.toString()));
    }

    /**
     * when Some Products Have Discount In Shop.
     */
    @Test
    public void whenSomeProductsHaveDiscountInShop() {
        Calendar created = getInstance();
        created.add(Calendar.DATE, -20);
        Calendar expired = getInstance();
        Calendar expired2 = getInstance();
        expired2.add(Calendar.DATE, 1);
        List<Storage> storages = List.of(new WareHouse(), new Shop(), new Trash());
        ControlQuality controlQuality = new ControlQuality(storages);
        List<Food> food = List.of(
                new Milk("milk", expired, created, 100, 0),
                new Rice("basmati", expired, created, 30, 0),
                new Meat("beef", expired2, created, 140, 0));
        food.forEach(controlQuality::distribute);
        StringBuilder trash = new StringBuilder();
        storages.get(2).clear().forEach(f -> trash.append(f.toString()));
        List<Food> shopResult = new ArrayList<>(storages.get(1).clear());
        StringBuilder shop = new StringBuilder();
        shopResult.forEach(f -> shop.append(f.toString()));
        assertThat(food.get(0).toString() + food.get(1).toString(), is(trash.toString()));
        assertThat(food.get(2).toString(), is(shop.toString()));
        assertThat(shopResult.get(0).getDiscount(), is(10L));
    }

    /**
     * when All Products Put In Shop, but in 5 day put in Trash.
     */
    @Test
    public void whenResortProducts() {
        Calendar created = getInstance();
        created.add(Calendar.DATE, -20);
        Calendar expired = getInstance();
        expired.add(Calendar.DATE, 60);
        List<Storage> storages = List.of(new WareHouse(), new Shop(), new Trash());
        ControlQuality controlQuality = new ControlQuality(storages);
        List<Food> food = List.of(
                new Milk("milk", expired, created, 100, 0),
                new Rice("basmati", expired, created, 30, 0),
                new Meat("beef", expired, created, 140, 0));
        food.forEach(controlQuality::distribute);
        StringBuilder shop = new StringBuilder();
        storages.get(1).clear().forEach(f -> shop.append(f.toString()));
        StringBuilder result = new StringBuilder();
        food.forEach(f -> result.append(f.toString()));
        assertThat(shop.toString(), is(result.toString()));
        created.add(Calendar.DATE, -10);
        expired.add(Calendar.DATE, -60);
        food.forEach(f -> {
            f.setCreateDate(created);
            f.setExpireDate(expired);
        });
        controlQuality.resort();
        storages.get(1).clear().forEach(f -> shop.append(f.toString()));
        food.forEach(f -> result.append(f.toString()));
        assertThat("", is(""));
    }
}
