package ru.job4j.lsp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Item {

    private final String name;
    private List<Item> children = new ArrayList<>();

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Item item) {
        children.add(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return name.equals(item.name) && Objects.equals(children, item.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children);
    }
}
