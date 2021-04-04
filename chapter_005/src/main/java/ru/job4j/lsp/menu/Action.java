package ru.job4j.lsp.menu;

public class Action implements UserAction{
    @Override
    public void choose(Item item) {
       System.out.println("You choose:" + "'" + item.getName() + "'");
    }
}
