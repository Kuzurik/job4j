package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * Menu for tracker
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class MenuTracker {
    
    private final Input input;
    private final SqlTracker sqlTracker;
    private final Consumer<String> output;
    private final List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, SqlTracker sqlTracker, Consumer<String> output) {
        this.input = input;
        this.sqlTracker = sqlTracker;
        this.output = output;
    }

    /**
     * store menu
     */

    public void fillActions(StartUI ui) {
        this.actions.add(0, new AddItem(0, "Add the new item"));
        this.actions.add(1, new ShowAll(1, "Show all items"));
        this.actions.add(2, new EditItem(2, "Edit item"));
        this.actions.add(3, new DeleteItem(3, "Delete item"));
        this.actions.add(4, new FindItemById(4, "Find item by id"));
        this.actions.add(5, new FindItemByName(5, "Find item by name"));
        this.actions.add(6, new Exit(ui, 6, "Exit program"));
    }

    /**
     * performs an action depending on the key
     * @param key
     */

    public void select(int key) throws SQLException {
        this.actions.get(key).execute(this.input, this.sqlTracker, this.output);
    }

    /**
     * show menu
     */

    public void show() {
        this.actions.forEach(i -> this.output.accept(i.info()));
    }

    public int getActionsLength() {
        return this.actions.size();
    }
    

    private static class AddItem extends BaseAction {

        protected AddItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, SqlTracker sqlTracker, Consumer<String> output) throws SQLException {
            output.accept("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите комментарий : ");
            Item item = new Item(String.valueOf(System.currentTimeMillis() + new Random().nextInt()),name, desc, System.currentTimeMillis());
            sqlTracker.add(item);
            output.accept(String.format("---%s---%s---%s", item.getId(), item.getName(), item.getDecs()));
        }

    }

    private static class ShowAll extends BaseAction {

        protected ShowAll(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, SqlTracker sqlTracker, Consumer<String> output) throws SQLException {
            List<Item> list = sqlTracker.findAll();
            for (Item value : list) {
                output.accept(String.format("---%s---%s---%s", value.getId(), value.getName(), value.getDecs()));
            }
        }
    }

    private static class EditItem extends BaseAction {

        protected EditItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, SqlTracker sqlTracker, Consumer<String> output) throws SQLException {
            output.accept("-----------------Редактируем заявку-----------------");
            String id = input.ask("Введите id заявки : ");
            String name = input.ask("Введите новое имя : ");
            String desc = input.ask("Введите новый комментарий : ");
            Item item = new Item(String.valueOf(System.currentTimeMillis() + new Random().nextInt()), name, desc, System.currentTimeMillis());
            boolean value = sqlTracker.replace(id, item);
            if (!value) {
                output.accept("Ничего не найдено!");
            } else {
                output.accept("Операция произведена успешно !");
            }
        }
    }

    private static class DeleteItem extends BaseAction {

        protected DeleteItem(int key, String name) {
            super(key, name);
        }


        public void execute(Input input, SqlTracker sqlTracker, Consumer<String> output) throws SQLException {
           output.accept("---------------Удаляем заявку----------------");
            String id = input.ask("Введите id заявки : ");
            boolean value = sqlTracker.delete(id);
            if (!value) {
                output.accept("Ничего не найдено!");
            } else {
                output.accept("Операция произведена успешно !");
            }
        }
    }

    private static class FindItemById extends BaseAction {

        protected FindItemById(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, SqlTracker sqlTracker, Consumer<String> output) throws SQLException {
            output.accept("---------------Ищем по id-------------");
            String id = input.ask("Введите id : ");
            Item value = sqlTracker.findById(id);
            if (value.equals(null)) {
                output.accept("Ничего не найдено !");
            } else {
                output.accept(String.format("---%s---%s---%s", value.getId(), value.getName(), value.getDecs()));
            }
        }
    }

    private static class FindItemByName extends BaseAction {

        protected FindItemByName(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, SqlTracker sqlTracker, Consumer<String> output) throws SQLException {
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

    private static class Exit extends BaseAction {
        private final StartUI ui;

        protected Exit(StartUI ui, int key, String name) {
            super(key, name);
            this.ui = ui;
        }


        public void execute(Input input, SqlTracker sqlTracker, Consumer<String> output) {
           ui.setExit(false);
        }
    }


}
