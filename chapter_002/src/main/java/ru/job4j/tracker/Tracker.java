package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * The class generates an id, adds items, removes items,
 * replace items, find all items, find the id and find the name.
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {

    private final List<Item> items = new ArrayList<>();
    private static final Random RND = new Random();





    /**
     * add an item.
     * @param item
     * @return item.
     */
    
    public Item add(Item item) {
        item.setId(this.generatedId());
        items.add(item);
        return item;
    }

    /**
     * generates id.
     * @return String id.
     */

    private int generatedId() {
        return RND.nextInt();
    }

    /**
     * Replace item.
     * @param id
     * @param item
     * @return true or false.
     */

    public boolean replace(int id, Item item) {
        boolean result = false;
       int index = 0;
            for (Item value : this.items) {
                if (value != null && value.getId() == id) {
                    int id1 = value.getId();
                    this.items.set(index, item);
                    this.items.get(index).setId(id1);
                    result = true;
                    break;
                }
                index++;
            } 
        return result;
    }

    /**
     * delete item and move an array.
     * @param id
     * @return true or false.
     */

    public boolean delete(int id) {
            int index = 0;
                for (Item value : this.items) {
                    if (value != null && value.getId() == id) {
                        this.items.remove(index);
                        return  true;
                    }
                    index++;
                }        
            return false;
    }

    /**
     * find all items.
     * @return array with all items.
     */

    public List<Item> findAll() {
       return this.items;
    }

    /**
     * looking for an item by name.
     * @param key
     * @return array with items.
     */

    public List<Item> findByName(String key) {
         List<Item> result = new ArrayList<>();

             for (Item value : this.items) {
                if (value != null && value.getName().equals(key)) {
                    result.add(value);
             }
         }
        return result;
    }

    /**
     * looking for an item by id.
     * @param id
     * @return found item.
     */

    public Item findById(int id) {
       Item result = null;
        for (Item value : items) {
            if (value != null && value.getId() == id) {
                result = value;
                break;
            }
        }
            return result;
    }

}
