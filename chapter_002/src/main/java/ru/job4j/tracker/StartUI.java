package ru.job4j.tracker;

import java.util.Date;

/**
 * Main class for tracker
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Menu
     */

    public void showMenu() {
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find item by name");
        System.out.println("6. Exit program");
    }

    /**
     * Add new item
     */

    public void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите комментарий : ");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
        System.out.println("---" + item.getId() + "---" + item.getName() + "---" + item.getDecs());
    }

    /**
     * Show all item
     */

    public void showAll() {
        Item[] item = tracker.findAll();
        for (int i = 0; i != item.length; i++) {
            System.out.println("---  " + item[i].getId() + "  ---  " + item[i].getName() + "  ---  " + item[i].getDecs());
        }
    }

    /**
     * Replace item
     */

    public void editItem() {
        boolean value;

            System.out.println("-----------------Редактируем заявку-----------------");
            String id = this.input.ask("Введите id заявки : ");
            String name = this.input.ask("Введите новое имя : ");
            String desc = this.input.ask("Введите новый комментарий : ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            value = this.tracker.replace(id, item);
            if (!value) {
                System.out.println("Ничего не найдено!");
            } else {
                System.out.println("Операция произведена успешно !");
            }
    }

    /**
     * delete item
     */

    public void deleteItem() {
        boolean value;

        System.out.println("---------------Удаляем заявку----------------");
        String id = this.input.ask("Введите id заявки : ");
        value = this.tracker.delete(id);
        if (!value) {
            System.out.println("Ничего не найдено!");
        } else {
            System.out.println("Операция произведена успешно !");
        }
    }

    /**
     * Find item by id
     */

    public void findItemById() {

        System.out.println("---------------Ищем по id-------------");
        String id = this.input.ask("Введите id : ");
        Item value = this.tracker.findById(id);
        if (value.equals(null)) {
            System.out.println("Ничего не найдено !");
        } else {
            System.out.println(value.getId() + "---" + value.getName() + "---" + value.getDecs());
        }
    }

    /**
     * Find item by name
     */

    public void findItemByName() {
        System.out.println("---------------Ищем по имени-------------");
        String name = this.input.ask("Введите имя : ");
        Item[] value = this.tracker.findByName(name);
        if (value.length == 0) {
            System.out.println("Ничего не найдено !");
        } else {
            for (int i = 0; i != value.length; i++) {
                System.out.println(value[i].getId() + "---" + value[i].getName() + "---" + value[i].getDecs());
            }
        }
    }

    public void init() {
        while (EXIT.equals("6")) {
            this.showMenu();
            String answer = input.ask("Select : ");
            if (EXIT.equals(answer)) {
                break;
            } else if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                 this.showAll();
            } else if (EDIT.equals(answer)) {
                 this.editItem();
            } else if (DELETE.equals(answer)) {
                 this.deleteItem();
            } else if (FINDID.equals(answer)) {
                 this.findItemById();
            } else if (FINDNAME.equals(answer)) {
                 this.findItemByName();
            } else {
               System.out.println(answer + "-" + " Could not find command");
            }
        }
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    } 
}
