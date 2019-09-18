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
        this.actions[0] = new AddItem(0, "Add the new item" );
        this.actions[1] = new ShowAll(1,  "Show all items");
        this.actions[2] = new EditItem(2, "Edit item");
        this.actions[3] = new DeleteItem(3, "Delete item");
        this.actions[4] = new FindItemById(4, "Find item by id");
        this.actions[5] = new FindItemByName(5, "Find item by name");
        this.actions[6] = new Exit(ui ,6, "Exit program");
    }

    /**
     * performs an action depending on the key
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

    public int getActionsLength() {
        return this.actions.length;
    }
    

    private class AddItem extends BaseAction {

        protected AddItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите комментарий : ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.add(item);
            System.out.printf("---%s---%s---%s" + System.lineSeparator(), item.getId(), item.getName(), item.getDecs());
        }

    }

    private class ShowAll extends BaseAction {

        protected ShowAll(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            Item[] item = tracker.findAll();
            for (int i = 0; i != item.length; i++) {
                System.out.printf("---%s---%s---%s" + System.lineSeparator(), item[i].getId(), item[i].getName(), item[i].getDecs());
            }
        }
    }

    private class EditItem extends BaseAction {

        protected EditItem(int key, String name) {
            super(key, name);
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
    }

    private class DeleteItem extends BaseAction {

        protected DeleteItem(int key, String name) {
            super(key, name);
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
    }

    private class FindItemById extends BaseAction {

        protected FindItemById(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------Ищем по id-------------");
            String id = input.ask("Введите id : ");
            Item value = tracker.findById(id);
            if (value.equals(null)) {
                System.out.println("Ничего не найдено !");
            } else {
                System.out.printf("---%s---%s---%s" + System.lineSeparator(), value.getId(), value.getName(), value.getDecs());
            }
        }
    }

    private class FindItemByName extends BaseAction {

        protected FindItemByName(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------Ищем по имени-------------");
            String name = input.ask("Введите имя : ");
            Item[] value = tracker.findByName(name);
            if (value.length == 0) {
                System.out.println("Ничего не найдено !");
            } else {
                for (int i = 0; i != value.length; i++) {
                    System.out.printf("---%s---%s---%s" + System.lineSeparator(), value[i].getId(), value[i].getName(), value[i].getDecs());
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


        public void execute(Input input, Tracker tracker) {
           ui.setExit(false);
        }
    }
}
