package ru.job4j.lsp.menu;

import java.util.Scanner;

public class DoAction implements Action {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String ask() {
        return this.scanner.nextLine();
    }

    @Override
    public String ask(Menu menu) throws Exception {
        String ask = this.ask();
        boolean exist = menu.findBy(ask).getItem().getName().isEmpty();
        if (!exist) {
            throw new Exception("out of menu range.");
        }
        System.out.println("You change menu item" + "'" + ask +"'");
        return ask;
    }
}
