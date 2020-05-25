package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Menu for tracker
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class MenuTracker {
    
    private Input input;
    private Tracker tracker;
    private final Consumer<String> output;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * store menu
     */

    public void fillActions(StartUI ui) {
        this.actions.add(0, new AddItem(0, "Add the new item"));
        this.actions.add(1, new ShowAll(1,  "Show all items"));
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

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker, this.output);
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
    

    private class AddItem extends BaseAction {

        protected AddItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker, Consumer<String> output) {
            output.accept("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите комментарий : ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.add(item);
            output.accept(String.format("---%s---%s---%s", item.getId(), item.getName(), item.getDecs()));
        }

    }

    private class ShowAll extends BaseAction {

        protected ShowAll(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker, Consumer<String> output) {
            List<Item> list = tracker.findAll();
            for (Item value : list) {
                output.accept(String.format("---%s---%s---%s", value.getId(), value.getName(), value.getDecs()));
            }
        }
    }

    private class EditItem extends BaseAction {

        protected EditItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker, Consumer<String> output) {
            output.accept("-----------------Редактируем заявку-----------------");
            String id = input.ask("Введите id заявки : ");
            String name = input.ask("Введите новое имя : ");
            String desc = input.ask("Введите новый комментарий : ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            boolean value = tracker.replace(id, item);
            if (!value) {
                output.accept("Ничего не найдено!");
            } else {
                output.accept("Операция произведена успешно !");
            }
        }
    }

    private class DeleteItem extends BaseAction {

        protected DeleteItem(int key, String name) {
            super(key, name);
        }


        public void execute(Input input, Tracker tracker, Consumer<String> output) {
           output.accept("---------------Удаляем заявку----------------");
            String id = input.ask("Введите id заявки : ");
            boolean value = tracker.delete(id);
            if (!value) {
                output.accept("Ничего не найдено!");
            } else {
                output.accept("Операция произведена успешно !");
            }
        }
    }

    private class FindItemById extends BaseAction {

        protected FindItemById(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker, Consumer<String> output) {
            output.accept("---------------Ищем по id-------------");
            String id = input.ask("Введите id : ");
            Item value = tracker.findById(id);
            if (value.equals(null)) {
                output.accept("Ничего не найдено !");
            } else {
                output.accept(String.format("---%s---%s---%s", value.getId(), value.getName(), value.getDecs()));
            }
        }
    }

    private class FindItemByName extends BaseAction {

        protected FindItemByName(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker, Consumer<String> output) {
            output.accept("---------------Ищем по имени-------------");
            String name = input.ask("Введите имя : ");
            List<Item> list = tracker.findByName(name);
            if (list.size() == 0) {
                output.accept("Ничего не найдено !");
            } else {
                for (Item value : list) {
                    output.accept(String.format("---%s---%s---%s", value.getId(), value.getName(), value.getDecs()));
                }
            }
        }
    }

    private class Exit extends BaseAction {
        private final StartUI ui;

        protected Exit(StartUI ui, int key, String name) {
            super(key, name);
            this.ui = ui;
        }


        public void execute(Input input, Tracker tracker, Consumer<String> output) {
           ui.setExit(false);
        }
    }


}
