package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 *  Tests methods add, replace, delete, findAll, findByName, findById.
 */

public class TrackerTest {

    /**
     * Test method add.
     */

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    /**
     * Test method replace.
     */

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
        }

    /**
     * Test method delete.
     */
    
    @Test
    public void whenDeleteThanTrue() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "description", 12L);
        tracker.add(item);
        Item item1 = new Item("name1", "description1", 25L);
        tracker.add(item1);
        Item item2 = new Item("name2", "description2", 35L);
        tracker.add(item2);
        assertThat(tracker.delete((item2.getId())), is(true));
    }

    /**
     * Test method findAll.
     */

    @Test
    public void whenFindAllThanAllArray() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "description", 12L);
        tracker.add(item);
        Item item1 = new Item("name1", "description1", 25L);
        tracker.add(item1);
        Item item2 = new Item("name2", "description2", 35L);
        tracker.add(item2);
        Item[] result = tracker.findAll();
        Item[] expected = new Item[] {item, item1, item2};
        assertThat(result, is(expected));
    }

    /**
     * Test method findByName.
     */

    @Test
    public void whenFindByNameThanNewArray() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "description", 12L);
        tracker.add(item);
        Item item1 = new Item("name1", "description1", 25L);
        tracker.add(item1);
        Item item2 = new Item("name", "description2", 35L);
        tracker.add(item2);
        Item[] result = tracker.findByName("name");
        Item[] expected = new Item[] {item, item2};
        assertThat(result, is(expected));
    }

    /**
     * Test method findById.
     */

    @Test
    public void whenFindByIdReturnId() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "description", 12L);
        tracker.add(item);
        Item item1 = new Item("name1", "description1", 25L);
        tracker.add(item1);
        Item item2 = new Item("name", "description2", 35L);
        tracker.add(item2);
        assertThat(tracker.findById(item1.getId()), is(item1));
    }
}
