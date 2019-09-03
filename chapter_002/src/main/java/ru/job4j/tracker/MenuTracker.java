package ru.job4j.tracker;

/**
 * Menu for tracker
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class MenuTracker {
    
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * store menu
     */

    public void fillActions(StartUI ui) {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAll();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemByName();
        this.actions[6] = new Exit(ui);
    }

    /**
     * performs an action depending on the keyю
     * @param key
     */

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker); 
    }

    /**
     * show menu
     */

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }


    /**
     * returns an exit variable
     * @return
     */



    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите комментарий : ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.add(item);
            System.out.printf("---%s---%s---%s\n", item.getId(), item.getName(), item.getDecs());
        }
    
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");
        }
    }

    private class ShowAll implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            Item[] item = tracker.findAll();
            for (int i = 0; i != item.length; i++) {
                System.out.printf("---%s---%s---%s\n", item[i].getId(), item[i].getName(), item[i].getDecs());
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    private class EditItem implements UserAction {
        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("-----------------Редактируем заявку-----------------");
            String id = input.ask("Введите id заявки : ");
            String name = input.ask("Введите новое имя : ");
            String desc = input.ask("Введите новый комментарий : ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            boolean value = tracker.replace(id, item);
            if (!value) {
                System.out.println("Ничего не найдено!");
            } else {
                System.out.println("Операция произведена успешно !");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }

    private class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------Удаляем заявку----------------");
            String id = input.ask("Введите id заявки : ");
            boolean value = tracker.delete(id);
            if (!value) {
                System.out.println("Ничего не найдено!");
            } else {
                System.out.println("Операция произведена успешно !");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    private class FindItemById implements UserAction {
        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------Ищем по id-------------");
            String id = input.ask("Введите id : ");
            Item value = tracker.findById(id);
            if (value.equals(null)) {
                System.out.println("Ничего не найдено !");
            } else {
                System.out.printf("---%s---%s---%s\n", value.getId(), value.getName(), value.getDecs());
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id");
        }
    }

    private class FindItemByName implements UserAction {
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------Ищем по имени-------------");
            String name = input.ask("Введите имя : ");
            Item[] value = tracker.findByName(name);
            if (value.length == 0) {
                System.out.println("Ничего не найдено !");
            } else {
                for (int i = 0; i != value.length; i++) {
                    System.out.printf("---%s---%s---%s\n", value[i].getId(), value[i].getName(), value[i].getDecs());
                }
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name");
        }
    }

    private class Exit implements UserAction {
        private final StartUI ui;

        Exit(StartUI ui) {
            this.ui = ui;
        }

        public int key() {
            return 6;
        }

        public void execute(Input input, Tracker tracker) {
            this.ui.stopUI();
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Exit program");
        }
    }
}
