package ru.job4j.lsp.menu;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final Item item;
    private List<Node> children = new ArrayList<Node>();

    public Node(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public List<Node> getChildren() {
        return children;
    }
}
