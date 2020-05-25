package ru.job4j.simpleset;

import java.util.Iterator;

import ru.job4j.simplearraylist.ListArray;

public class SimpleSet<E> implements Iterable<E> {
    private ListArray<E> values = new ListArray<>();

    public void add(E e) {
        if (!contains(e)) {
            this.values.add(e);
        }
     }

     public boolean contains(E e) {
        boolean result = false;
         for (Object value : this.values) {
             if (value.equals(e)) {
                 result = true;
                 break;
             }
         }
         return result;
     }

    @Override
    public Iterator<E> iterator() {
        return values.iterator();
    }
}
