package ru.job4j.lsp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.lsp.menu.*;
import ru.job4j.lsp.menu.Exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MenuTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void whenFindItem() {
        Item item = new Item("MENU");
        Item item1 = new Item("MENU1");
        Item item2 = new Item("MENU1.1");
        Node root = new Node(item);
        Menu menu = new Menu(root);
        menu.add(item, item1);
        menu.add(item1, item2);
        assertThat(item2, is(menu.findBy(item2.getName()).getItem()));
    }

    @Test
    public void whenAddItem() {
        Item item = new Item("MENU");
        Item item1 = new Item("MENU1");
        Item item2 = new Item("MENU1.1");
        Node root = new Node(item);
        Menu menu = new Menu(root);
        menu.add(item, item1);
        menu.add(item1, item2);
        assertThat(item2, is(menu.findBy(item2.getName()).getItem()));
    }

    @Test
    public void whenShowAllMenu() {
        Item item = new Item("MENU");
        Item item1 = new Item("MENU1");
        Item item2 = new Item("MENU1.1");
        Item item3 = new Item("MENU2");
        Item item4 = new Item("MENU2.1");
        Node root = new Node(item);
        Menu menu = new Menu(root);
        menu.add(item, item1);
        menu.add(item1, item2);
        menu.add(item, item3);
        menu.add(item3,item4);
        StringBuilder expected = new StringBuilder();
        expected.append("MENU1").append(System.lineSeparator());
        expected.append("----MENU1.1").append(System.lineSeparator());
        expected.append("MENU2").append(System.lineSeparator());
        expected.append("----MENU2.1").append(System.lineSeparator());
        String result = menu.show();
        assertThat(result, is(expected.toString()));
    }

    @Test()
    public void whenChooseItemMenu() throws Exception {
        Item item = new Item("MENU");
        Item item1 = new Item("MENU1");
        Item item2 = new Item("MENU1.1");
        Node root = new Node(item);
        Menu menu = new Menu(root);
        menu.add(item, item1);
        menu.add(item1, item2);
        UserAction action = menu.choose(item2);
        action.act();
        Assert.assertEquals("You choose: MENU1.1", output.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
