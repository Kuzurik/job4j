package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;

import java.sql.SQLException;
import java.util.Random;
import java.util.function.Consumer;

public class EditItem extends BaseAction {

    public EditItem(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Store sqlTracker, Consumer<String> output) throws SQLException {
        output.accept("-----------------Редактируем заявку-----------------");
        int id = Integer.parseInt(input.ask("Введите id заявки : "));
        String name = input.ask("Введите новое имя : ");
        String desc = input.ask("Введите новый комментарий : ");
        Item item = new Item(new Random().nextInt(), name, desc, System.currentTimeMillis());
        boolean value = sqlTracker.replace(id, item);
        if (!value) {
            output.accept("Ничего не найдено!");
        } else {
            output.accept("Операция произведена успешно !");
        }
    }
}
