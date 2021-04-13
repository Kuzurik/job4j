package ru.job4j.lsp.menu;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Menu implements Add, FindBy, ShowMenu {

    private final Node root;

    public Menu(Node root) {
        this.root = root;
    }

    @Override
    public boolean add(Item parent, Item child) {
        boolean rsl = false;
        Node node = findBy(parent.getName());
        if (node != null) {
            node.getChildren().add(new Node(child));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Node findBy(String name) {
        Node rsl = null;
        Queue<Node> data = new LinkedList<>();
        data.add(this.root);
        while (!data.isEmpty()) {
            Node el = data.poll();
            if (el.getItem().getName().equals(name)) {
                rsl = el;
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }

    public String show() {
        StringBuilder builder = new StringBuilder();
        for (Node node : root.getChildren()) {
            builder.append(showMenu(node, 0));
        }
        return builder.toString();
    }

    private String showMenu(Node node, int depth) {
        StringBuilder builder = new StringBuilder();
        String tab = "----".repeat(depth);
        builder.append(tab).append(node.getItem().getName()).append(System.lineSeparator());

        if (node.getChildren().size() > 0) {
            for (Node child : node.getChildren()) {
                builder.append(showMenu(child, depth + 1));
            }
        }
        return builder.toString();
    }

    public UserAction choose(Item item) throws Exception {
        Item currentItem = findBy(item.getName()).getItem();
        if (currentItem == null) {
            throw new Exception("Item not found!");
        }
        return () -> System.out.print("You choose: " + currentItem.getName());
    }



}
