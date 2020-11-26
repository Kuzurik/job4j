package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;

import java.sql.SQLException;
import java.util.Random;
import java.util.function.Consumer;

public class AddItem extends BaseAction {
    public AddItem(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Store sqlTracker, Consumer<String> output) throws SQLException {
        output.accept("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки : ");
        String desc = input.ask("Введите комментарий : ");
        Item item = new Item(new Random().nextInt(), name, desc, System.currentTimeMillis());
        sqlTracker.add(item);
        output.accept(String.format("---%s---%s---%s", item.getId(), item.getName(), item.getDecs()));
    }
}
