package simpleSet;

import simpleArrayList.ListArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<E> implements Iterable<E> {
    private ListArray<E> values = new ListArray<>();
    private int position = 0;

    public void add(E e) {
       boolean check = true;
       for (Object value : this.values) {
           if (value.equals(e)) {
               check = false;
               break;
           }
       }
       if (check) {
           values.add(e);
           position++;
       }
     }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return this.cursor < position;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return values.get(cursor++);
            }
        };
    }
}
