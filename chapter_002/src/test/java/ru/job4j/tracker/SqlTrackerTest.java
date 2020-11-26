package ru.job4j.tracker;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static final Logger LOG = LogManager.getLogger(SqlTracker.class.getName());

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item(new Random().nextInt(),
                    "test1", "desc of test1", System.currentTimeMillis());
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName(), is(item.getName()));
        } catch (Exception e) {
            LOG.error(e);
        }

    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item previous = new Item(new Random().nextInt(),
                    "test1", "desc of test1", System.currentTimeMillis());
            tracker.add(previous);
            Item next = new Item(new Random().nextInt(),
                    "test2", "desc of test2", System.currentTimeMillis());
            next.setId(previous.getId());
            tracker.replace(previous.getId(), next);
            assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
        } catch (Exception e) {
            LOG.error(e);
        }
    }

    @Test
    public void whenDeleteThenReturnNull() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item i1 = new Item(new Random().nextInt(),
                    "test1", "desc of test1", System.currentTimeMillis());
            tracker.add(i1);
            tracker.delete(i1.getId());
            assertNull(tracker.findById(i1.getId()));
        } catch (Exception e) {
            LOG.error(e);
        }
    }

    @Test
    public void whenFindAll() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item i1 = new Item(new Random().nextInt(),
                    "test1", "desc of test1", System.currentTimeMillis());
            tracker.add(i1);
            Item i2 = new Item(new Random().nextInt(),
                    "test2", "desc of test2", System.currentTimeMillis());
            tracker.add(i2);
            Item i3 = new Item(new Random().nextInt(),
                    "test1", "desc of test1", System.currentTimeMillis());
            tracker.add(i3);
            List<Item> allItems = tracker.findAll();
            List<Item> testRes = List.of(i1, i2, i3);
            assertEquals(testRes, allItems);
        } catch (Exception e) {
            LOG.error(e);
        }
    }

    @Test
    public void whenFindByName() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item i1 = new Item(new Random().nextInt(),
                    "test1", "desc of test1", System.currentTimeMillis());
            tracker.add(i1);
            Item i2 = new Item(new Random().nextInt(),
                    "test2", "desc of test2", System.currentTimeMillis());
            tracker.add(i2);
            Item i3 = new Item(new Random().nextInt(),
                    "test1", "desc of test1", System.currentTimeMillis());
            tracker.add(i3);
            List<Item> allItems = tracker.findByName("test1");
            List<Item> testRes = List.of(i1, i3);
            assertEquals(testRes, allItems);
        } catch (Exception e) {
            LOG.error(e);
        }
    }
}
