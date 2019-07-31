package ru.job4j.tracker;
import java.util.Random;
import java.util.Arrays;

/**
 * The class generates an id, adds items, removes items,
 * replace items, find all items, find the id and find the name.
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {

    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RND = new Random();

    /**
     * add an item.
     * @param item
     * @return item.
     */
    
    public Item add(Item item) {
        item.setId(this.generatedId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * generates id.
     * @return String id.
     */

    private String generatedId() {
        return String.valueOf(System.currentTimeMillis() + RND.nextInt());
    }

    /**
     * Replace item.
     * @param id
     * @param item
     * @return true or falce.
     */

    public boolean replace(String id, Item item) {
        boolean result = false;
            for (Item elements : items) {
                if (elements != null && elements.getId().equals(id)) {
                    elements.setName(item.getName());
                    elements.setDecs(item.getDecs());
                    elements.setTime(item.getTime());
                    result = true;
                    break;
                }
            } 
        return result;
    }

    /**
     * delete item and move an array.
     * @param id
     * @return true or false.
     */

    public boolean delete(String id) {
            boolean result = false;
                for (int i = 0; i != position; i++) {
                    if (items[i] != null && items[i].getId().equals(id)) {
                        System.arraycopy(items, i + 1, items, i, position - i - 1);
                        result = true;
                        position--;
                        break;
                    }
                }        
            return result;
    }

    /**
     * find all items.
     * @return array with all items.
     */

    public Item[] findAll() {
        Item[] result = new Item[position];
            for (int i = 0; i != result.length; i++) {
                result[i] = this.items[i];
            }
        return result;
    }

    /**
     * looking for an item by name.
     * @param key
     * @return array with items.
     */

    public Item[] findByName(String key) {
        int count = 0;
        Item[] result = new Item[position];
            for (int i = 0; i != items.length; i++) {
                if (this.items[i] != null && this.items[i].getName().equals(key)) {
                    result[count++] = items[i];
             }
         }
        return Arrays.copyOf(result, count);
    }

    /**
     * looking for an item by id.
     * @param id
     * @return found item.
     */

    public Item findById(String id) {
       Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
            return result;
    }

}
