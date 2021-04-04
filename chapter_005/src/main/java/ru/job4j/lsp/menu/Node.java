package ru.job4j.lsp.menu;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final Item item;
    private List<Node> children = new ArrayList<Node>();
    private final UserAction action;

    public Node(Item item, UserAction action) {
        this.item = item;
        this.action = action;
    }

    public Item getItem() {
        return item;
    }

    public List<Node> getChildren() {
        return children;
    }
}
