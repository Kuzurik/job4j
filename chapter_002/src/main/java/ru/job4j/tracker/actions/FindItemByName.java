package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

public class FindItemByName extends BaseAction {

    public FindItemByName(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Store sqlTracker, Consumer<String> output) throws SQLException {
        output.accept("---------------Ищем по имени-------------");
        String name = input.ask("Введите имя : ");
        List<Item> list = sqlTracker.findByName(name);
        if (list.size() == 0) {
            output.accept("Ничего не найдено !");
        } else {
            for (Item value : list) {
                output.accept(String.format("---%s---%s---%s", value.getId(), value.getName(), value.getDecs()));
            }
        }
    }
}
