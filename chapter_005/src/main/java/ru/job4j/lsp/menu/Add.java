package ru.job4j.lsp.menu;

import java.util.Optional;

public interface Add {
    boolean add(Item parent, Item child, UserAction action);
}
