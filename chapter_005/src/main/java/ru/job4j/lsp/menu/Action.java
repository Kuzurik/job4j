package ru.job4j.lsp.menu;

public interface Action {
    String ask();
    String ask(Menu menu) throws Exception;
}
