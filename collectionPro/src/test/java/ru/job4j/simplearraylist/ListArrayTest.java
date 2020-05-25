package ru.job4j.simplearraylist;


import org.junit.Before;
import org.junit.Test;

import ru.job4j.simplearraylist.ListArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListArrayTest {
    private ListArray<Integer> list;

    @Before
    public void beforeTest() {
        list = new ListArray<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddReturnFirstElement() {
        assertThat(list.get(1), is(1));
    }

    @Test
    public void whenAddThirtyElements() {
        for (int i = 0; i != 30; i++) {
            list.add(i);
        }
    }

    @Test
    public void whenRemoveReturnFirstElement() {
        list.remove(0);
        assertThat(list.get(0), is(1));
    }

    @Test
    public void whenTestIterator() {
        Iterator interList = list.iterator();
        assertThat(interList.hasNext(), is(true));
        assertThat(interList.next(), is(0));
        assertThat(interList.next(), is(1));
        assertThat(interList.next(), is(2));
        assertThat(interList.next(), is(3));
        assertThat(interList.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenNextRemoveValueReturnException() {
        Iterator interList = list.iterator();
        interList.next();
        interList.next();
        list.remove(1);
        interList.next();
    }
}
